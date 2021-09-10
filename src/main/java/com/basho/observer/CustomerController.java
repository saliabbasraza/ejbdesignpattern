package com.basho.observer;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import static com.basho.observer.CustomerEvent.Type.ADD;
import static com.basho.observer.CustomerEvent.Type.REMOVE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Stateless
@Path("/customer")
public class CustomerController {

    @Inject
    @CustomerEvent(ADD)
    public Event<Customer> addCustomerEvent;

    @Inject
    @CustomerEvent(REMOVE)
    public Event<Customer> deleteCustomerEvent;

    @POST
    @Consumes(APPLICATION_JSON)
    public void addCustomer(Customer customer) {
        addCustomerEvent.fire(customer);
    }

    @DELETE
    @Consumes(APPLICATION_JSON)
    public void deleteCustomer(Customer customer) {
        deleteCustomerEvent.fire(customer);
    }
}
