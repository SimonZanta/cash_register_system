package com.example.DBConnected.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//this file is used to map get, post etc. and what will happen if we call them
@RestController
public class EmployeeController {
    private final EmployeeRepo personRepo;
    public EmployeeController(EmployeeRepo personRepo){
        this.personRepo = personRepo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/login")
    public Employee findEmployees(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = personRepo.findByUsername(employeeDTO.getUsername());
        if(employee == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "nejaka error hlaska");

        }
        if(employee.getPassword().equals(employeeDTO.getPassword())){
            return employee;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "nejaka error hlaska");
    }

    @PostMapping("/register")
    public Employee addOneEmployee(@RequestBody Employee person){
        return this.personRepo.save(person);
    }
}
