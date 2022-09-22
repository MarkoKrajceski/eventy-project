package com.example.eventmanagement.xport.events;

import com.example.eventmanagement.domain.models.*;
import com.example.eventmanagement.service.*;
import com.example.sharedkernel.domain.config.*;
import com.example.sharedkernel.domain.events.*;
import com.example.sharedkernel.domain.events.eventys.*;
import lombok.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

@Service
@AllArgsConstructor
public class EventyEventListener {
    private final EventService eventService;

    @KafkaListener(topics= TopicHolder.TOPIC_EVENT_CREATED, groupId = "eventManagement")
    public void consumeCustomerItemCreatedEvent(String jsonMessage) {
        try {
            EventCreated event = DomainEvent.fromJson(jsonMessage,EventCreated.class);
            eventService.eventCreated(EventId.of(event.getEventId()), event.getName());
        } catch (Exception e){

        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_EVENT_REMOVED, groupId = "eventManagement")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            EventRemoved event = DomainEvent.fromJson(jsonMessage,EventRemoved.class);
            eventService.eventRemoved(EventId.of(event.getEventId()), event.getEventName());
        } catch (Exception e){

        }

    }
}
