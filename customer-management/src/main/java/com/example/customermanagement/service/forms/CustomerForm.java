package com.example.customermanagement.service.forms;

import lombok.*;

import javax.validation.*;
import javax.validation.constraints.*;
import java.util.*;

@Data
public class CustomerForm {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

    @Valid
    @NotEmpty
    private  List<CustomerEventItemForm> items = new ArrayList<>();

}
