package com.example.EmployeemanagementSystem.service;

import com.example.EmployeemanagementSystem.dto.DepartmentsDto;
import com.example.EmployeemanagementSystem.entity.Departments;
import com.example.EmployeemanagementSystem.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Departments saveDepartment(DepartmentsDto departmentsDto) {

        Departments departments = new Departments();
       departments.setDepartmentName(departmentsDto.getDepartmentName());
       departments.setActive(true);
       departments.setCreatedBy(departmentsDto.getCreatedBy());
       departments.setCreatedDate(LocalDateTime.now());
       departments.setUpdatedBy(departmentsDto.getUpdatedBy());
       departments.setUpdatedDate(LocalDateTime.now());

        return departmentRepository.save(departments);
    }

    public List<Departments> getAllDepartments() {
        List list = departmentRepository.findAll();
        return list;
    }

    public Departments updateDepartment(DepartmentsDto departmentsDto, Integer departmentId) {
        Departments department = new Departments();
        try {
            department = departmentRepository.findById(departmentId).get();
        }catch (Exception e){
            System.out.println("Department not found");
            return null;
        }

        if(Objects.nonNull(departmentsDto.getDepartmentName()) &&  !"".equalsIgnoreCase(departmentsDto.getDepartmentName())){
            department.setDepartmentName(departmentsDto.getDepartmentName());
        }
        if(Objects.nonNull(departmentsDto.isActive())){
            department.setActive(departmentsDto.isActive());
        }
        if(Objects.nonNull(departmentsDto.getCreatedBy()) && !"".equalsIgnoreCase(departmentsDto.getCreatedBy())){
            department.setCreatedDate(departmentsDto.getCreatedDate());
        }
        if(Objects.nonNull(departmentsDto.getUpdatedBy()) && !"".equalsIgnoreCase(departmentsDto.getUpdatedBy())){
            department.setUpdatedBy(departmentsDto.getUpdatedBy());
        }
        department.setUpdatedDate(LocalDateTime.now());

        return departmentRepository.save(department);

    }

    public String deleteDepartment(Integer departmentId) {
       if(departmentRepository.existsById(departmentId)){
           departmentRepository.deleteById(departmentId);
           return "Department has been deleted";
       }else{
           return null;
       }
    }
}
