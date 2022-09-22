package com.example.eventmanagement.xport.rest;

import com.example.eventmanagement.domain.models.*;
import com.example.eventmanagement.service.*;
import com.example.eventmanagement.service.form.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getCustomers(){
        return this.eventService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable String id) {
        EventId customerId = new EventId(id);

        try{
            Event eventResponse = this.eventService.findById(customerId);
            return ResponseEntity.ok().body(eventResponse);
        }catch (Exception error){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Event> save(@RequestBody EventForm eventForm) {
        try{
            Event eventResponse = this.eventService.createEvent(eventForm);
            return ResponseEntity.ok().body(eventResponse);
        }catch (Exception error){
            return ResponseEntity.badRequest().build();
        }
    }
}
