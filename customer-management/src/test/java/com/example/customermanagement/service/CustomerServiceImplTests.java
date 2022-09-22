package com.example.customermanagement.service;

import com.example.customermanagement.domain.exceptions.*;
import com.example.customermanagement.domain.models.*;
import com.example.customermanagement.domain.valueobjects.*;
import com.example.customermanagement.service.forms.*;
import com.example.customermanagement.xport.client.*;
import com.example.sharedkernel.domain.financial.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.*;
import java.util.Currency;

@SpringBootTest
public class CustomerServiceImplTests {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EventClient eventClient;

    public CustomerServiceImplTests() {
    }

    private static Event newEvent(String name) {
        Event event = new Event((EventId) EventId.randomId(EventId.class), name);
        return event;
    }

    @Test
    public void testPlaceOrder() {
        CustomerEventItemForm cei1 = new CustomerEventItemForm();
        cei1.setEvent(newEvent("setEvent1"));
        CustomerEventItemForm cei2 = new CustomerEventItemForm();
        cei2.setEvent(newEvent("setEvent2"));
        CustomerForm customerForm = new CustomerForm();
        customerForm.setEmail("test@test.com");
        customerForm.setName("test");
        customerForm.setPassword("test123");
        customerForm.setItems(Arrays.asList(cei1, cei2));
        CustomerId newCustomerId = this.customerService.createCustomer(customerForm);
        Customer newCustomer = (Customer) this.customerService.findById(newCustomerId).orElseThrow(CustomerIdNotExistException::new);
        System.out.println("passed");
    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<Event> productList = this.eventClient.findAll();
        Event p1 = (Event)productList.get(0);
        Event p2 = (Event)productList.get(1);
        CustomerEventItemForm cei1 = new CustomerEventItemForm();
        cei1.setEvent(p1);
        CustomerEventItemForm cei2 = new CustomerEventItemForm();
        cei2.setEvent(p2);
        CustomerForm customerForm = new CustomerForm();
        customerForm.setItems(Arrays.asList(cei1, cei2));
        CustomerId newCustomerId = this.customerService.createCustomer(customerForm);
        Order newOrder = (Order)this.customerService.findById(newCustomerId).orElseThrow(CustomerIdNotExistException::new);
    }
}
