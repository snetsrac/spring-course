package com.snetsrac.springdemo.dao;

import java.util.List;

import com.snetsrac.springdemo.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // Get the current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Create a query
        Query<Customer> query = session.createQuery("from Customer order by lastName",
                Customer.class);

        // Get the result list
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        // Get the session
        Session session = sessionFactory.getCurrentSession();

        // Save the new customer to the database
        session.save(customer);
    }
}
