package com.example.EmployeemanagementSystem.controller;

import com.example.EmployeemanagementSystem.dto.DepartmentsDto;
import com.example.EmployeemanagementSystem.entity.Departments;
import com.example.EmployeemanagementSystem.repo.DepartmentRepository;
import com.example.EmployeemanagementSystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dpt")
public class DepartmentsController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/save")
    public ResponseEntity<Departments> saveDepartment(@RequestBody DepartmentsDto departmentsDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentsDto), HttpStatus.CREATED);
    }


    @GetMapping("/getall")
    public ResponseEntity<List<Departments>> getAllDepartments(){
        return  new ResponseEntity<>(departmentService.getAllDepartments(),HttpStatus.FOUND);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDepartment(@RequestBody DepartmentsDto departmentsDto,
                                                    @PathVariable("id") Integer departmentId){
        Departments department  = departmentService.updateDepartment(departmentsDto,departmentId);
        if(department==null){
            return new ResponseEntity<>("Department Not Found for id "+departmentId,HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(department,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") Integer  departmentId){
        String message = departmentService.deleteDepartment(departmentId);
        if(message == null){
            return  new ResponseEntity<>("Department not found for id "+departmentId, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(message , HttpStatus.GONE);
        }

    }


}
