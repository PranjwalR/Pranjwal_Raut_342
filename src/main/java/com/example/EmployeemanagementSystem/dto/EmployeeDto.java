package com.example.EmployeemanagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDto {

    private String employeeFirstName;
    private String employeeLastName;
    private int employeeAge;
    private String employeeEmail;
    private String dateOfJoining;
    private String salary;

    private boolean isActive;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

}
