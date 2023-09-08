package com.novi.TechItEasy.controllers;

import com.novi.TechItEasy.exceptions.RecordNotFoundException;
import com.novi.TechItEasy.model.Television;
import com.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/techItEasy")

public class TelevisionController {
    @Autowired
    private TelevisionRepository televisionRepo;

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok(televisionRepo.findAll());
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        televisionRepo.save(television);
        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/" + television.getId()).toUriString());
        return ResponseEntity.created(uri).body(television);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television televisionDetails) {
        Optional<Television> updateTelevision = televisionRepo.findById(id);
        if (updateTelevision.isPresent()) {
            Television newDetailsOfTelevision = updateTelevision.get();
            newDetailsOfTelevision.setHdr(televisionDetails.getHdr());
            newDetailsOfTelevision.setAmbiLight(televisionDetails.getAmbiLight());
            newDetailsOfTelevision.setAvailableSize(televisionDetails.getAvailableSize());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}


//    private List<Television> tv;// 1. declare the list
//
//    public TelevisionController() {
//        tv = new ArrayList<>();// 2. initialise the list
//        Television tele = new Television(); // instantiate the class Television
////        tele.setBrandName("onida");//setting the attributes to the instance of television
////        tele.setTeleType("LCD");
//        tv.add(tele); // 3. adding list to instance of television class
//    }