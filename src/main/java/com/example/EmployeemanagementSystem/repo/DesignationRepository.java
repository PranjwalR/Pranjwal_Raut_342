package com.example.EmployeemanagementSystem.repo;

import com.example.EmployeemanagementSystem.entity.Designations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designations,Integer> {
}
