package com.snetsrac.springdemo.springbootemployee.dao;

import com.snetsrac.springdemo.springbootemployee.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
