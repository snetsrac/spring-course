package com.snetsrac.springdemo.controller;

import com.snetsrac.springdemo.entity.Customer;
import com.snetsrac.springdemo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "list-customers";
    }

    @GetMapping("/showForm")
    public String showAddCustomerForm(@RequestParam(required = false) Integer id, Model model) {
        Customer customer = id == null ? new Customer() : customerService.getCustomerById(id);

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processCustomerForm(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customer/list";
    }
}
