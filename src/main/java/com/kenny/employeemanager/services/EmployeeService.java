package com.kenny.employeemanager.services;

import com.kenny.employeemanager.exeption.UserNotFoundException;
import com.kenny.employeemanager.models.Employee;
import com.kenny.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return  employeeRepo.save(employee);
    }
    public Employee findEmployeeById(long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("employee with "+id+" not found"));
    }
    public void deleteEmployee(long id){
         employeeRepo.deleteEmployeeById(id);
    }
}
