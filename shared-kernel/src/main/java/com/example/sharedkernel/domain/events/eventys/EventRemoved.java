package com.example.sharedkernel.domain.events.eventys;

import com.example.sharedkernel.domain.config.*;
import com.example.sharedkernel.domain.events.*;
import lombok.*;

@Getter
public class EventRemoved extends DomainEvent {
    private String eventId;
    private String eventName;

    public EventRemoved(String topic) {
        super(TopicHolder.TOPIC_EVENT_REMOVED);
    }

    public EventRemoved(String topic, String eventId, String eventName) {
        super(TopicHolder.TOPIC_EVENT_REMOVED);
        this.eventId = eventId;
        this.eventName = eventName;
    }
}
