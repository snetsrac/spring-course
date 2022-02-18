package com.snetsrac.springdemo.springbootemployee.service;

import java.util.List;

import com.snetsrac.springdemo.springbootemployee.dao.EmployeeRepository;

// import javax.transaction.Transactional;

// import com.snetsrac.springdemo.springbootemployee.dao.EmployeeDAO;
import com.snetsrac.springdemo.springbootemployee.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    // @Autowired
    // @Qualifier("employeeDAOJPAImpl")
    // private EmployeeDAO employeeDAO;

    // @Override
    // @Transactional
    // public List<Employee> findAll() {
    //     return employeeDAO.findAll();
    // }

    // @Override
    // @Transactional
    // public Employee findById(int id) {
    //     return employeeDAO.findById(id);
    // }

    // @Override
    // @Transactional
    // public void save(Employee employee) {
    //     employeeDAO.save(employee);
    // }

    // @Override
    // @Transactional
    // public void deleteById(int id) {
    //     employeeDAO.deleteById(id);
    // }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);        
    }
}
