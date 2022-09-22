package com.example.customermanagement.domain.valueobjects;

import com.example.sharedkernel.domain.base.*;

import javax.persistence.*;

@Embeddable
public class EventId extends DomainObjectId {
    private EventId() {
        super(EventId.randomId(EventId.class).getId());
    }

    public EventId(String uuid) {
        super(uuid);
    }
}