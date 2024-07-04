package com.kushagrapaliwal.rest.services;

import com.kushagrapaliwal.rest.dto.EmployeeDTO;
import com.kushagrapaliwal.rest.entities.EmployeeEntity;
import com.kushagrapaliwal.rest.repositories.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper){
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getemployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createnewemployee(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEntity = employeeRepo.save(employeeEntity);
        return modelMapper.map(savedEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getallemployes(){
            return employeeRepo
                    .findAll()
                    .stream()
                    .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                    .collect(Collectors.toList());
    }

    public boolean deleteemployeeById(Long id){
        boolean isPresent  = employeeRepo.existsById(id);
        if(!isPresent) return false ;
        employeeRepo.deleteById(id);
        return true ;
    }
}
