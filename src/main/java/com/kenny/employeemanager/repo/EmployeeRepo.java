package com.kenny.employeemanager.repo;

import com.kenny.employeemanager.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee , Integer> {

     void deleteEmployeeById(long id);

     Optional<Employee> findEmployeeById(long id);
}
