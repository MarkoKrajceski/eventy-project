package com.example.customermanagement.service;

import com.example.customermanagement.domain.exceptions.*;
import com.example.customermanagement.domain.models.*;
import com.example.customermanagement.service.forms.*;

import java.util.*;

public interface CustomerService {

    CustomerId createCustomer(CustomerForm customerForm);

    List<Customer> findAll();

    Optional<Customer> findById(CustomerId id);

    void addItem(CustomerId customerId, CustomerEventItemForm customerEventItemForm) throws CustomerIdNotExistException;

    void deleteItem(CustomerId customerId, CustomerEventItemId customerEventItemId) throws CustomerIdNotExistException, CustomerEventItemIdNotExistException;

}
