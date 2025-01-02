package com.example.EmployeemanagementSystem.service;

import com.example.EmployeemanagementSystem.dto.DesignationDto;
import com.example.EmployeemanagementSystem.entity.Designations;
import com.example.EmployeemanagementSystem.repo.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class DesignationService {
    @Autowired
    DesignationRepository designationRepository;
    public Designations saveDesignation(DesignationDto designationDto) {
        Designations designations = new Designations();
        designations.setDesignationName(designationDto.getDesignationName());
        designations.setActive(true);
        designations.setCreatedBy(designationDto.getCreatedBy());
        designations.setCreatedDate(LocalDateTime.now());
        designations.setUpdatedBy(designationDto.getUpdatedBy());
        designations.setUpdatedDate(LocalDateTime.now());

        return designationRepository.save(designations);
    }

    public List<Designations> getAllDesignations() {
        List list = designationRepository.findAll();
        return list;
    }

    public Designations updateDesignation(DesignationDto designationDto, Integer designationId) {
        Designations designation = new Designations();
        try {
            designation = designationRepository.findById(designationId).get();
        }catch (NoSuchElementException e){
            System.out.println("Designation Not Found");
            return  null;
        }

        if(Objects.nonNull(designationDto.getDesignationName()) &&  !"".equalsIgnoreCase(designationDto.getDesignationName())){
            designation.setDesignationName(designationDto.getDesignationName());
        }
        if(Objects.nonNull(designationDto.isActive())){
            designation.setActive(designationDto.isActive());
        }
        if(Objects.nonNull(designationDto.getCreatedBy()) && !"".equalsIgnoreCase(designationDto.getCreatedBy())){
            designation.setCreatedDate(designationDto.getCreatedDate());
        }
        if(Objects.nonNull(designationDto.getUpdatedBy()) && !"".equalsIgnoreCase(designationDto.getUpdatedBy())){
            designation.setUpdatedBy(designationDto.getUpdatedBy());
        }
        designation.setUpdatedDate(LocalDateTime.now());

        return designationRepository.save(designation);
    }

    public String deleteDesignation(Integer designationID) {
        if(designationRepository.existsById(designationID)){
            designationRepository.deleteById(designationID);
            return "Designation has been deleted";
        }else{
            return null;
        }
    }
}
