package com.example.EmployeemanagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.naming.factory.SendMailFactory;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name= "Employeeinfo")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
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
