package com.example.datajpaexceptions.service;

import com.example.datajpaexceptions.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void createEmployee(Employee employee);
    void deleteEmployee(Long id);

}
