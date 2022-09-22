package com.example.eventmanagement.domain.models;

import com.example.sharedkernel.domain.base.*;
import lombok.*;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "event")
@Getter
public class Event extends AbstractEntity<EventId> {
    @Column(name = "event_name")
    private String name;

    @Column(name = "event_startTime")
    private LocalDateTime startTime;

    @Column(name = "event_endTime")
    private LocalDateTime endTime;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Stage> stages = new HashSet<>();


    private Location location;

    public Location getLocation() {
        return location;
    }

    private Event() {
        super(EventId.randomId(EventId.class));
    }

    private Event(String name) {
        super(EventId.randomId(EventId.class));
        this.name = name;
    }

    public Event(String name, LocalDateTime startTime, LocalDateTime endTime) {
        super(EventId.randomId(EventId.class));
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public static Event build(String eventName) {
        Event event = new Event();
        event.name = eventName;
        return event;
    }
}
