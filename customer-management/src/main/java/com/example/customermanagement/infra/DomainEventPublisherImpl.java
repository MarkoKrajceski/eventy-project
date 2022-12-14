package com.example.customermanagement.infra;

import lombok.AllArgsConstructor;
import com.example.sharedkernel.domain.events.DomainEvent;
import com.example.sharedkernel.infra.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DomainEventPublisherImpl implements DomainEventPublisher {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void publish(DomainEvent event) {
        this.kafkaTemplate.send(event.topic(),event.toJson());
    }
}
