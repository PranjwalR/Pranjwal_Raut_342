package com.example.EmployeemanagementSystem.controller;

import com.example.EmployeemanagementSystem.dto.ManagersDto;
import com.example.EmployeemanagementSystem.entity.Employee;
import com.example.EmployeemanagementSystem.entity.Managers;
import com.example.EmployeemanagementSystem.service.ManagersService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/man")
public class ManagersController {
    @Autowired
    ManagersService managersService;

    @PostMapping("/save")
    public ResponseEntity<Managers> saveManager(@RequestBody ManagersDto managersDto)
    {
        return new ResponseEntity<>(managersService.saveManager(managersDto), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Managers>> getAllManagers(){
        return new ResponseEntity<>(managersService.getAllManagers(),HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateManager(@RequestBody ManagersDto managersDto,
                                                  @PathVariable("id") Integer managerId){
        Managers manager = managersService.updateManager(managersDto,managerId);
        if(manager == null){
            return  new ResponseEntity<>("Manager Not Found for id " + managerId,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(manager,HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteManager(@PathVariable("id") Integer managerId){
        String message  = managersService.deleteManager(managerId);
        if(message == null){
            return new ResponseEntity<>("Manager not found for id "+managerId,HttpStatus.NOT_FOUND);
        }else{
           return new ResponseEntity<>(message,HttpStatus.GONE);
        }
    }
}
