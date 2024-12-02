package com.example.EmployeemanagementSystem.repo;

import com.example.EmployeemanagementSystem.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments,Integer> {
}
