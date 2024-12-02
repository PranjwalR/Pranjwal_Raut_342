package com.example.EmployeemanagementSystem.repo;

import com.example.EmployeemanagementSystem.entity.Managers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagersRepository extends JpaRepository<Managers,Integer> {
}
