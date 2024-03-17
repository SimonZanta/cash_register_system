package com.example.DBConnected.Authorization;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorizationController {
    private final AuthorizationRepo authorizationRepo;
    public AuthorizationController(AuthorizationRepo authorizationRepo){
        this.authorizationRepo = authorizationRepo;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/Authorization")
    public Iterable<Authorization> findAllEmployees(){
        return this.authorizationRepo.findAll();
    }

    @PostMapping("/Authorization")
    public Authorization addOneEmployee(@RequestBody Authorization authorization){
        return this.authorizationRepo.save(authorization);
    }

}
