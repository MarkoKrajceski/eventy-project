package com.example.customermanagement.domain.financial;

import com.example.sharedkernel.domain.base.*;
import lombok.*;

import javax.persistence.*;

@Embeddable
@Getter
public class Quantity implements ValueObject {

    private final int quantity;

    protected Quantity() {
        this.quantity = 0;
    }

}
