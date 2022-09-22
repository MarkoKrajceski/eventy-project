package com.example.customermanagement.service.forms;

import com.example.customermanagement.domain.valueobjects.*;
import lombok.*;

import javax.validation.constraints.*;

@Data
public class CustomerEventItemForm {

    @NotNull
    private Event event;
}
