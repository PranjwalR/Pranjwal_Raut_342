package com.example.EmployeemanagementSystem.service;

import com.example.EmployeemanagementSystem.dto.EmployeeDto;
import com.example.EmployeemanagementSystem.entity.Employee;
import com.example.EmployeemanagementSystem.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmpId(0);
        employee.setEmpFirstName(employeeDto.getEmpFirstName());
        employee.setEmpLastName(employeeDto.getEmpLastName());
        employee.setEmpEmail(employeeDto.getEmpEmail());
        employee.setDoj(employeeDto.getDoj());
        employee.setEmpAge(employeeDto.getEmpAge());
        employee.setSalary(employeeDto.getSalary());
        employee.setActive(true);
        employee.setCreatedBy(employeeDto.getCreatedBy());
        employee.setCreatedDate(LocalDateTime.now());
        employee.setUpdatedBy(employeeDto.getUpdatedBy());
        employee.setUpdatedDate(LocalDateTime.now());
        return employeeRepository.save(employee);
    }
}
