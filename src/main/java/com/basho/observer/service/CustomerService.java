package com.basho.observer.service;

import com.basho.observer.Customer;
import com.basho.observer.CustomerEvent;

import javax.annotation.Priority;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import static com.basho.observer.CustomerEvent.Type.ADD;
import static com.basho.observer.CustomerEvent.Type.REMOVE;

@Stateless
public class CustomerService {
    public void createCustomer(@Observes @Priority(10) @CustomerEvent(ADD) Customer customer) {
        System.out.println("createCustomer");
    }

    public void removeCustomer(@Observes @Priority(10) @CustomerEvent(REMOVE) Customer customer) {
        System.out.println("removeCustomer");
    }
}
