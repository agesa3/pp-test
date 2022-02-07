package com.agesadev.employee.repository;

import com.agesadev.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(long employeeId);
}
