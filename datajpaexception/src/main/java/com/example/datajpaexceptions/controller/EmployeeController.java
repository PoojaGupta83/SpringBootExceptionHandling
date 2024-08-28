package com.example.datajpaexceptions.controller;

import com.example.datajpaexceptions.entity.Employee;
import com.example.datajpaexceptions.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
public List<Employee> getAllEmployee(){
   return employeeService.getAllEmployees();
}

@GetMapping("/get/{id}")
public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
     Employee employee=employeeService.getEmployeeById(id);
     return employee!=null?ResponseEntity.ok(employee):ResponseEntity.notFound().build();
}

@PostMapping("/add")
public  void createEmployee(@RequestBody Employee employee){
    employeeService.createEmployee(employee);
}



@DeleteMapping("/delete")
public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
}
}
