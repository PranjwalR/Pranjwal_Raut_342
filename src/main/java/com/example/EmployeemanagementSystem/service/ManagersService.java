package com.example.EmployeemanagementSystem.service;

import com.example.EmployeemanagementSystem.dto.ManagersDto;
import com.example.EmployeemanagementSystem.entity.Employee;
import com.example.EmployeemanagementSystem.entity.Managers;
import com.example.EmployeemanagementSystem.repo.ManagersRepository;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class ManagersService {

    @Autowired
    ManagersRepository managersRepository;

    public Managers saveManager(ManagersDto managersDto) {
        Managers manager = new Managers();
         manager.setManagerId(0);
         manager.setManagerName(managersDto.getManagerName());
         manager.setActive(true);
         manager.setCreatedBy(managersDto.getCreatedBy());
         manager.setCreatedDate(LocalDateTime.now());
         manager.setUpdatedBy(managersDto.getUpdatedBy());
         manager.setUpdatedDate(LocalDateTime.now());

        return managersRepository.save(manager);
    }

    public List<Managers> getAllManagers() {
       List list = managersRepository.findAll();

        return list;
    }

    public Managers updateManager(ManagersDto managersDto, Integer managerId) {
        Managers manager = new Managers();
        try {
            manager = managersRepository.findById(managerId).get();
        }catch (NoSuchElementException e){
            System.out.println("Manager not found");
            return null;
        }
        if(Objects.nonNull(managersDto.getManagerName()) &&  !"".equalsIgnoreCase(managersDto.getManagerName())){
            manager.setManagerName(managersDto.getManagerName());
        }
        if(Objects.nonNull(managersDto.isActive())){
            manager.setActive(managersDto.isActive());
        }
        if(Objects.nonNull(managersDto.getCreatedBy()) && !"".equalsIgnoreCase(managersDto.getCreatedBy())){
            manager.setCreatedDate(managersDto.getCreatedDate());
        }
        if(Objects.nonNull(managersDto.getUpdatedBy()) && !"".equalsIgnoreCase(managersDto.getUpdatedBy())){
            manager.setUpdatedBy(managersDto.getUpdatedBy());
        }
        manager.setUpdatedDate(LocalDateTime.now());

        return managersRepository.save(manager);
    }

    public String deleteManager(Integer managerId) {

        if (managersRepository.existsById(managerId)) {
            managersRepository.deleteById(managerId);
            return "Manager has been deleted";
        } else {
            return null;
        }
    }
}
