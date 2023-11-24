package com.employeemanagerapp.EmployeeManagerApplication.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
