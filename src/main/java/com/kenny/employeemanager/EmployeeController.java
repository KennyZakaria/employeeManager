package com.kenny.employeemanager;

import com.kenny.employeemanager.models.Employee;
import com.kenny.employeemanager.services.EmployeeService;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/")
    public String sayHi(){
        return "hiiiiiiiii";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees , HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee , HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(newEmployee , HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(updatedEmployee , HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
