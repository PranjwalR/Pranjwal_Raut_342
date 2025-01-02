package com.example.EmployeemanagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepartmentsDto {

    private String departmentName;

    private boolean isActive;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;
}
