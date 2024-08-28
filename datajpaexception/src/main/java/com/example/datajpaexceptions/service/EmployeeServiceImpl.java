package com.example.datajpaexceptions.service;

import com.example.datajpaexceptions.entity.Employee;
import com.example.datajpaexceptions.exception.BadRequestException;
import com.example.datajpaexceptions.exception.EntityNotFoundException;
import com.example.datajpaexceptions.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException("Employee Not found with this id"+id));
    }

    @Override
    public void createEmployee(Employee employee) {
        if(employee.getEmail()==null||employee.getEmail().isEmpty()){
            throw new BadRequestException("Email is mandatory");
        }
        repository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);

    }
}
