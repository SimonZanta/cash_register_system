package com.example.idk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class IdkController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/test")
    public Test test(@RequestParam(value = "name", defaultValue = "firstName") String name, @RequestParam(value = "surname", defaultValue = "lastName") String surname){
        return new Test(counter.incrementAndGet(), name, surname);
    }

}
