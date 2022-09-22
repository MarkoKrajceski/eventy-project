package com.example.customermanagement.xport.rest;


import com.example.customermanagement.domain.models.*;
import com.example.customermanagement.service.*;
import com.example.customermanagement.service.forms.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable String id) {
        CustomerId customerId = new CustomerId(id);
        return this.customerService.findById(customerId)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerId> save(@RequestBody CustomerForm customerForm) {
        try{
            CustomerId customerResponse = this.customerService.createCustomer(customerForm);
            return ResponseEntity.ok().body(customerResponse);
        }catch (Exception error){
            return ResponseEntity.badRequest().build();
        }
    }
}
