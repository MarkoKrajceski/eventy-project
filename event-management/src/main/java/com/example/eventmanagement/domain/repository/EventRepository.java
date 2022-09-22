package com.example.eventmanagement.domain.repository;

import com.example.eventmanagement.domain.models.*;
import org.springframework.data.jpa.repository.*;

public interface EventRepository extends JpaRepository<Event, EventId> {
}
