package com.example.customermanagement.service.impl;

import com.example.customermanagement.domain.exceptions.*;
import com.example.customermanagement.domain.models.*;
import com.example.customermanagement.domain.repository.*;
import com.example.customermanagement.domain.valueobjects.*;
import com.example.customermanagement.service.*;
import com.example.customermanagement.service.forms.*;

import com.example.sharedkernel.domain.events.eventys.*;
import com.example.sharedkernel.infra.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import javax.validation.*;
import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;

    @Override
    public CustomerId createCustomer(CustomerForm customerForm) {
        Objects.requireNonNull(customerForm,"order must not be null.");
        var constraintViolations = validator.validate(customerForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
        }
        var newCustomer = customerRepository.saveAndFlush(toDomainObject(customerForm));
        newCustomer.getEvents().forEach(item->domainEventPublisher.publish(new EventCreated(item.getEventId().getId(),item.getEventName())));
        return newCustomer.getId();
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findById(CustomerId id) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerIdNotExistException::new);
        return Optional.of(customer);
    }

    @Override
    public void addItem(CustomerId customerId, CustomerEventItemForm customerEventItemForm) throws CustomerIdNotExistException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerIdNotExistException::new);
        customer.addItem(customerEventItemForm.getEvent());
        customerRepository.saveAndFlush(customer);
        domainEventPublisher.publish(new EventCreated(customerEventItemForm.getEvent().getId().getId(), customerEventItemForm.getEvent().getName()));

    }


    @Override
    public void deleteItem(CustomerId customerId, CustomerEventItemId customerEventItemId) throws CustomerIdNotExistException, CustomerEventItemIdNotExistException {

    }

    private Customer toDomainObject(CustomerForm customerForm) {
        var customer = new Customer(customerForm.getName(), customerForm.getEmail(), customerForm.getPassword());
        Event event = new Event();
        customer.addItem(event);

        customerForm.getItems().forEach(item->customer.addItem(item.getEvent()));
        return customer;
    }
}
