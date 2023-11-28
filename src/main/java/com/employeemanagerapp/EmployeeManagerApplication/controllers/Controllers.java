package com.employeemanagerapp.EmployeeManagerApplication.controllers;

import com.employeemanagerapp.EmployeeManagerApplication.model.Employee;
import com.employeemanagerapp.EmployeeManagerApplication.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/employee")
public class Controllers {

    private EmployeeService employeeService;

    @Autowired
    public Controllers(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/all-employees")
    public ResponseEntity<List<Employee>> showAllEmployees() {
        List<Employee> employees =  employeeService.findAllEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping(path = "/employee{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping(path = "/add-new-employee")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update-employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(path = "/delete-employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
