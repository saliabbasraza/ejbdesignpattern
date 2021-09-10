package com.basho.observer.service;

import com.basho.observer.Customer;
import com.basho.observer.CustomerEvent;

import javax.annotation.Priority;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import static com.basho.observer.CustomerEvent.Type.ADD;

@Stateless
public class EmailService {
    public void sendWelcomeEmail(@Observes @Priority(1000) @CustomerEvent(ADD) Customer customer) {
        System.out.println("sendWelcomeEmail");
    }
}
