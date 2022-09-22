package com.example.customermanagement.domain.models;

import com.example.customermanagement.domain.valueobjects.*;
import com.example.customermanagement.domain.models.CustomerEventItem;
import com.example.sharedkernel.domain.base.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "customer")
@Getter
public class Customer extends AbstractEntity<CustomerId>{
    private String name;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CustomerEventItem> events = new HashSet<>();

    private Customer(){super(CustomerId.randomId(CustomerId.class));}

    public Customer(String name, String email, String password){
        super(CustomerId.randomId(CustomerId.class));
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public CustomerEventItem addItem(@NonNull Event event) {
        Objects.requireNonNull(event,"product must not be null");
        var item  = new CustomerEventItem(event.getId(), event.getName());
        events.add(item);
        return item;
    }

    public void removeItem(@NonNull CustomerEventItemId customerEventItemId) {
        Objects.requireNonNull(customerEventItemId,"Order Item must not be null");
        events.removeIf(v->v.getEventId().equals(customerEventItemId));
    }
}
