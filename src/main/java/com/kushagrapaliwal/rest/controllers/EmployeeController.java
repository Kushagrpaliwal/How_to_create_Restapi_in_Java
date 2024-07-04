package com.kushagrapaliwal.rest.controllers;

import com.kushagrapaliwal.rest.dto.EmployeeDTO;
import com.kushagrapaliwal.rest.repositories.EmployeeRepo;
import com.kushagrapaliwal.rest.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//operations
//GET /employees
//POST /employess
//DELETE /employee/{id}

//              dto             entities
//presentation <-----> services <------> persistence


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService ;
    }


//    http://localhost:8080/employee/1
    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") Long EmployeeId){
       return employeeService.getemployeeById(EmployeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getallemployes(){
        return employeeService.getallemployes() ;
    }

//    http://localhost:8080/employee?name=kushagra&age=12&id=12
    @PostMapping
    public EmployeeDTO createnewemployee(@RequestBody EmployeeDTO employeedto){
            return employeeService.createnewemployee(employeedto);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteemployeeById(@PathVariable Long id){
       return  employeeService.deleteemployeeById(id);
    }


}
