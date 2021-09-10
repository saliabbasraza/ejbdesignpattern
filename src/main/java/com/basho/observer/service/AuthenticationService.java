package com.basho.observer.service;

import com.basho.observer.Customer;
import com.basho.observer.CustomerEvent;

import javax.annotation.Priority;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import static com.basho.observer.CustomerEvent.Type.ADD;

@Stateless
public class AuthenticationService {
    public void createCustomerCredentials(@Observes @Priority(100) @CustomerEvent(ADD) Customer customer) {
        System.out.println("createCustomerCredentials");
    }
}
