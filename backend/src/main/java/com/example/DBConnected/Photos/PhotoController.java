package com.example.DBConnected.Photos;

import com.example.DBConnected.Desk.Desk;
import com.example.DBConnected.Desk.DeskRepo;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhotoController {
        private final PhotoRepo photoRepo;

    public PhotoController(PhotoRepo photoRepo) {
        this.photoRepo = photoRepo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
        @GetMapping("/Photo")
        public Iterable<Photo> findAllEmployees(){
            return this.photoRepo.findAll();
        }

        @PostMapping("/Photo")
        public Photo addOneDesk(@RequestBody Photo photo){
            return this.photoRepo.save(photo);
        }

}
