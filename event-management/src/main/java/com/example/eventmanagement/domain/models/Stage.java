package com.example.eventmanagement.domain.models;

import com.example.sharedkernel.domain.base.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "stage")
public class Stage extends AbstractEntity<StageId> {
    private String name;
    @Embedded
    private Location location;

    public Location getLocation() {
        return location;
    }
    @OneToMany
    private Set<Performance> performances;
}
