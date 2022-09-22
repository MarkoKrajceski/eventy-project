package com.example.eventmanagement.service;

import com.example.eventmanagement.domain.models.*;
import com.example.eventmanagement.service.form.*;

import java.util.*;

public interface EventService {
    Event findById(EventId id);
    Event createEvent(EventForm form);
    Event eventCreated(EventId eventId, String name);
    Event eventRemoved(EventId eventId, String name);
    List<Event> getAll();
}
