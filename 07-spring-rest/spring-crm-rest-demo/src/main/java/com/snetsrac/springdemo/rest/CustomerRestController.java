package com.snetsrac.springdemo.rest;

import java.util.List;

import com.snetsrac.springdemo.entity.Customer;
import com.snetsrac.springdemo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        Customer customer = service.getCustomer(id);

        if (customer == null) {
            throw new CustomerNotFoundException("A customer with id " + id +
                    " could not be found.");
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        service.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        service.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        Customer customer = service.getCustomer(id);

        if (customer == null) {
            throw new CustomerNotFoundException("A customer with id " + id +
                    " could not be found.");
        }
        
        service.deleteCustomer(id);
        return "Deleted customer id = " + id;
    }
}
