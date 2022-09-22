package com.example.eventmanagement.domain.models;

import com.example.sharedkernel.domain.base.*;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "performance")
public class Performance extends AbstractEntity<PerformanceId> {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @OneToMany
    private Set<Artist> artists;
}
