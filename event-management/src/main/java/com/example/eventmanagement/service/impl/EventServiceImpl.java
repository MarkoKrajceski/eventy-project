package com.example.eventmanagement.service.impl;

import com.example.eventmanagement.domain.exceptions.*;
import com.example.eventmanagement.domain.models.*;
import com.example.eventmanagement.domain.repository.*;
import com.example.eventmanagement.service.*;
import com.example.eventmanagement.service.form.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public Event findById(EventId id) {
        return eventRepository.findById(id).orElseThrow(EventNotFoundException::new);
    }

    @Override
    public Event createEvent(EventForm form) {
        Event event = Event.build(form.getEventName());
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event eventCreated(EventId eventId, String name) {
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);
        //setStages
        eventRepository.saveAndFlush(event);
        return event;
    }

    @Override
    public Event eventRemoved(EventId eventId, String name) {
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);
        //setStages
        eventRepository.saveAndFlush(event);
        return event;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }
}
