package com.example.DBConnected.Desk;

import org.springframework.web.bind.annotation.*;

@RestController
public class DeskController {
    //this file is used to map get, post etc. and what will happen if we call them
        private final DeskRepo deskRepo;
        public DeskController(DeskRepo deskRepo){
            this.deskRepo = deskRepo;
        }

        //refactor on bigger codebase
        //needs CrossOrigin enabled globally, this is temporary localy
        //we need it enable otherwise next.js will cry that its disabled
        @CrossOrigin(origins = "http://localhost:3000")
        @GetMapping("/Desk")
        public Iterable<Desk> findAllEmployees(){
            return this.deskRepo.findAll();
        }

        @PostMapping("/Desk")
        public Desk addOneDesk(@RequestBody Desk desk){
            return this.deskRepo.save(desk);
        }

}
