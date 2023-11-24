package com.employeemanagerapp.EmployeeManagerApplication.service;

import com.employeemanagerapp.EmployeeManagerApplication.exceptions.UserNotFoundException;
import com.employeemanagerapp.EmployeeManagerApplication.model.Employee;
import com.employeemanagerapp.EmployeeManagerApplication.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    /* THE METHODS INCLUDED IN THE EMPLOYEE SERVICE ARE:
     *
     * addEmployee(Employee employee)
     * findAllEmployees()
     * findEmployeeById(Employee employee)
     * updateEmployee(Employee employee)
     * deleteEmployee(Employee employee)
     */

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User with id " + id + "was not found"));
    }

    public Employee updateEmployee(Employee employee) {
        return addEmployee(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
