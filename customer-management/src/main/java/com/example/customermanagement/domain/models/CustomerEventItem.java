package com.example.customermanagement.domain.models;

import com.example.customermanagement.domain.valueobjects.*;
import com.example.sharedkernel.domain.base.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer_event_item")
@Getter
public class CustomerEventItem extends AbstractEntity<CustomerEventItemId> {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "event_id", nullable = false))
    private EventId eventId;

    private String eventName;

    private CustomerEventItem() {
        super(DomainObjectId.randomId(CustomerEventItemId.class));
    }

    public CustomerEventItem(@NonNull EventId eventId, @NonNull String eventName) {
        super(DomainObjectId.randomId(CustomerEventItemId.class));
        this.eventId = eventId;
        this.eventName = eventName;
    }

}
