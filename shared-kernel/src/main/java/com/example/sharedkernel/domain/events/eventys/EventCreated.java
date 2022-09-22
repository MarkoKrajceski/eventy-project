package com.example.sharedkernel.domain.events.eventys;


import com.example.sharedkernel.domain.config.*;
import com.example.sharedkernel.domain.events.*;
import lombok.*;

@Getter
public class EventCreated extends DomainEvent {
    private String eventId;
    private String name;

    public EventCreated(String topic) {
        super(TopicHolder.TOPIC_EVENT_CREATED);
    }

    public EventCreated(String eventId, String name) {
        super(TopicHolder.TOPIC_EVENT_CREATED);
        this.eventId = eventId;
        this.name = name;
    }
}
