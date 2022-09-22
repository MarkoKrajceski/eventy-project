package com.example.customermanagement.domain.financial;

import com.example.sharedkernel.domain.base.*;
import com.example.sharedkernel.domain.financial.*;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan extends AbstractEntity<PlanId> {
    private PlanName planName;
    @Embedded
    private Money price;
    @Embedded
    private Quantity numberOfEvents;

    public Quantity getNumberOfEvents() {
        return numberOfEvents;
    }

    public Money getPrice() {
        return price;
    }
}
