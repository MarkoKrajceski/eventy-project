package com.example.customermanagement.domain.valueobjects;

import com.example.sharedkernel.domain.base.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
public class Event implements ValueObject {
    private final EventId id;
    private final String name;

    public Event() {
        this.id = EventId.randomId(EventId.class);
        this.name = "";
    }

    @JsonCreator
    public Event(@JsonProperty("id") EventId id,
                 @JsonProperty("eventName") String name){
        this.id = id;
        this.name = name;
    }
}
