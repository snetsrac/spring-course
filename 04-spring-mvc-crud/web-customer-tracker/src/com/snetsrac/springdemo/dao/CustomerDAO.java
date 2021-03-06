package com.snetsrac.springdemo.dao;

import java.util.List;

import com.snetsrac.springdemo.entity.Customer;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public Customer getCustomerById(int id);
    public void deleteCustomerById(int id);
}
