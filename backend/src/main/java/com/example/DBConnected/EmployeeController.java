package com.example.DBConnected;

import org.springframework.web.bind.annotation.*;

//this file is used to map get, post etc. and what will happen if we call them
@RestController
public class EmployeeController {
    private final EmployeeRepo personRepo;
    public EmployeeController(EmployeeRepo personRepo){
        this.personRepo = personRepo;
    }

    //refactor on bigger codebase
    //needs CrossOrigin enabled globally, this is temporary localy
    //we need it enable otherwise next.js will cry that its disabled
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Person")
    public Iterable<Employee> findAllEmployees(){
        return this.personRepo.findAll();
    }

    @PostMapping("/Person")
    public Employee addOneEmployee(@RequestBody Employee person){
        return this.personRepo.save(person);
    }
}
