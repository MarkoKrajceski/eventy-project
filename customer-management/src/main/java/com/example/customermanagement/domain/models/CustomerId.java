package com.example.customermanagement.domain.models;

import com.example.sharedkernel.domain.base.*;
import lombok.*;

public class CustomerId extends DomainObjectId {
    private CustomerId() {
        super(CustomerId.randomId(CustomerId.class).getId());
    }

    public CustomerId(@NonNull String uuid) {
        super(uuid);
    }
}
