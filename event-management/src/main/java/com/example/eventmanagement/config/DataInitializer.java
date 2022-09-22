package com.example.eventmanagement.config;

import com.example.eventmanagement.domain.models.*;
import com.example.eventmanagement.domain.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import javax.annotation.*;
import java.util.*;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final EventRepository eventRepository;

    @PostConstruct
    public void initData() {
        Event event1 = Event.build("DFest");
        Event event2 = Event.build("Ohrid Calling");
        if (eventRepository.findAll().isEmpty()) {
            eventRepository.saveAll(Arrays.asList(event1,event2));
        }
    }
}
