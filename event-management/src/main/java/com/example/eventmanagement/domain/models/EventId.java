package com.example.eventmanagement.domain.models;

import com.example.sharedkernel.domain.base.*;
import org.springframework.lang.*;

public class EventId extends DomainObjectId {
    private EventId() {
        super(EventId.randomId(EventId.class).getId());
    }

    public EventId(@NonNull String uuid) {
        super(uuid);
    }

    public static EventId of(String uuid) {
        EventId eventId = new EventId(uuid);
        return eventId;
    }
}
