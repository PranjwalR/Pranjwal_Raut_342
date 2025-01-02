package com.example.EmployeemanagementSystem.service;

import com.example.EmployeemanagementSystem.dto.EmployeeDto;
import com.example.EmployeemanagementSystem.entity.Employee;
import com.example.EmployeemanagementSystem.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmployeeId(0);
        employee.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
        employee.setEmployeeLastName(employeeDto.getEmployeeLastName());
        employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
        employee.setDateOfJoining(employeeDto.getDateOfJoining());
        employee.setEmployeeAge(employeeDto.getEmployeeAge());
        employee.setSalary(employeeDto.getSalary());
        employee.setActive(true);
        employee.setCreatedBy(employeeDto.getCreatedBy());
        employee.setCreatedDate(LocalDateTime.now());
        employee.setUpdatedBy(employeeDto.getUpdatedBy());
        employee.setUpdatedDate(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }

    public Employee updateEmployee(EmployeeDto employeeDto, Integer employeeID) {
        Employee employee;
        try{
            employee = employeeRepository.findById(employeeID).get();
        }catch(NoSuchElementException e){
            System.out.println("Employee not found for id "+ employeeID);
            return null;
        }

        if(Objects.nonNull(employeeDto.getEmployeeFirstName()) && !"".equalsIgnoreCase(employeeDto.getEmployeeFirstName())){
            employee.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
        }
        if(Objects.nonNull(employeeDto.getEmployeeLastName()) && !"".equalsIgnoreCase(employeeDto.getEmployeeLastName())){
            employee.setEmployeeLastName(employeeDto.getEmployeeLastName());
        }
        if(Objects.nonNull(employeeDto.getEmployeeEmail()) && !"".equalsIgnoreCase(employeeDto.getEmployeeEmail())){
            employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
        }
        if(Objects.nonNull(employeeDto.getDateOfJoining()) && !"".equalsIgnoreCase(employeeDto.getDateOfJoining())){
            employee.setDateOfJoining(employeeDto.getDateOfJoining());
        }
        if(Objects.nonNull(employeeDto.getEmployeeAge())){
            employee.setEmployeeAge(employeeDto.getEmployeeAge());
        }
        if (Objects.nonNull(employeeDto.getSalary())) {
            employee.setSalary(employeeDto.getSalary());
        }
        if (Objects.nonNull(employeeDto.isActive())) {
            employee.setActive(employeeDto.isActive());
        }
        if (Objects.nonNull(employeeDto.getCreatedBy()) && !"".equalsIgnoreCase(employeeDto.getCreatedBy())) {
            employee.setCreatedBy(employeeDto.getCreatedBy());
        }
        if (Objects.nonNull(employeeDto.getUpdatedBy()) && !"".equalsIgnoreCase(employeeDto.getUpdatedBy())) {
            employee.setUpdatedBy(employeeDto.getUpdatedBy());
        }
        employee.setUpdatedDate(LocalDateTime.now());

        return employeeRepository.save(employee);
    }

    public String deleteEmployee(Integer employeeId) {
        if(employeeRepository.existsById(employeeId)){
            employeeRepository.deleteById(employeeId);
            return "Employee has been deleted";
        }else{
            return null;
        }
    }
}
