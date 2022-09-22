package com.example.customermanagement.domain.models;

import com.example.sharedkernel.domain.base.*;
import lombok.*;

public class CustomerEventItemId extends DomainObjectId {

    private CustomerEventItemId() {
        super(CustomerEventItemId.randomId(CustomerEventItemId.class).getId());
    }

    public CustomerEventItemId(@NonNull String uuid) {
        super(uuid);
    }
}
