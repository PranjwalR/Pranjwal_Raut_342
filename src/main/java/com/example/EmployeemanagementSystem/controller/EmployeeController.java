package com.example.EmployeemanagementSystem.controller;

import com.example.EmployeemanagementSystem.dto.EmployeeDto;
import com.example.EmployeemanagementSystem.entity.Employee;
import com.example.EmployeemanagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ems")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                                   @PathVariable("id") Integer employeeID){
        Employee employee = employeeService.updateEmployee(employeeDto,employeeID);
        if(employee == null){
            return new ResponseEntity<>("Employee not found for id "+ employeeID, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer employeeId){
        String message = employeeService.deleteEmployee(employeeId);
        if(message == null){
            return new ResponseEntity<>("Employee not found for id "+ employeeId, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(message,HttpStatus.GONE);
        }
    }

}
