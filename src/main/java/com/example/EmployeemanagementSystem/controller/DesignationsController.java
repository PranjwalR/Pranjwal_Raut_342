package com.example.EmployeemanagementSystem.controller;

import com.example.EmployeemanagementSystem.dto.DesignationDto;
import com.example.EmployeemanagementSystem.dto.ManagersDto;
import com.example.EmployeemanagementSystem.entity.Designations;
import com.example.EmployeemanagementSystem.repo.ManagersRepository;
import com.example.EmployeemanagementSystem.service.DesignationService;
import com.example.EmployeemanagementSystem.service.ManagersService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/des")
public class DesignationsController {

    @Autowired
    DesignationService designationService;
    @PostMapping("/save")
    public ResponseEntity<Designations> saveDesignation(@RequestBody DesignationDto  designationDto)
    {
        return new ResponseEntity<>(designationService.saveDesignation(designationDto), HttpStatus.CREATED);
    }


    @GetMapping("/getall")
    public ResponseEntity<List<Designations>> getAllDesignations(){
        return new ResponseEntity<>(designationService.getAllDesignations(),HttpStatus.FOUND);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDesignation(@RequestBody DesignationDto designationDto,
                                                          @PathVariable("id") Integer designationId){
        Designations designation = designationService.updateDesignation(designationDto,designationId);
        if(designation == null){
            return new ResponseEntity<>("Designation not found for id "+ designationId,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(designation,HttpStatus.ACCEPTED);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDesignation(@PathVariable("id") Integer designationID){
        String message = designationService.deleteDesignation(designationID);
        if(message == null){
            return  new ResponseEntity<>("Designation not found for id "+ designationID ,HttpStatus.NOT_FOUND);
        }else{
            return  new ResponseEntity<>(message,HttpStatus.GONE);
        }
    }

}
