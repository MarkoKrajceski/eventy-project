package com.example.eventmanagement.domain.models;

import com.example.sharedkernel.domain.base.*;
import com.example.sharedkernel.domain.financial.*;
import lombok.*;

import javax.persistence.*;

@Embeddable
@Getter
public class Location implements ValueObject {
    private final String country;
    private final String address;


    protected Location() {
        this.country = "";
        this.address = "";
    }

    public Location(@NonNull String country, @NonNull String address) {
        this.country = country;
        this.address = address;
    }
}
