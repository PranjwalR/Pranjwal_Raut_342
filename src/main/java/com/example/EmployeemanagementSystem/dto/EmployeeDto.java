package com.example.EmployeemanagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDto {
    private String empFirstName;
    private String empLastName;
    private int empAge;
    private String empEmail;
    private String doj;
    private String salary;

    private boolean isActive;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

}
