package com.snetsrac.springdemo.springbootemployee.service;

import java.util.List;

import com.snetsrac.springdemo.springbootemployee.entity.Employee;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
