package com.agesadev.employee.service;

import com.agesadev.employee.model.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService {
    void AddEmployee(Employee employee);

    Employee getEmployeeById(long employeeId);

    void updateEmployee(Employee employee);

    void deleteEmployee(long employeeId);
}
