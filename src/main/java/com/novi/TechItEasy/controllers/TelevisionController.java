package com.novi.TechItEasy.controllers;

import com.novi.TechItEasy.dtos.TelevisionDto;
import com.novi.TechItEasy.services.TelevisionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/techItEasy/televisions")

public class TelevisionController {

    //    SERVICE LAYER
    @Autowired
    private final TelevisionServices televisonService;

    public TelevisionController(TelevisionServices televisonService) {
        this.televisonService = televisonService;
    }

    @GetMapping

//    calling getAllTelevisions method from the service

    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {

//        storing ths result in a list of TelevisionDto;
        List<TelevisionDto> televisions = televisonService.getTelevisions();
//        return televisions;
        return ResponseEntity.ok(televisions);
    }

    @PostMapping
    public ResponseEntity<Object> createTelevision(@RequestBody TelevisionDto televisionDto, BindingResult br) {
        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField());
                sb.append(":");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        } else {
            televisonService.createTelevision(televisionDto);
            URI uri = URI.create(ServletUriComponentsBuilder.
                    fromCurrentRequest().
                    path("/" + televisionDto.id).toUriString());
            return ResponseEntity.created(uri).body(televisionDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<TelevisionDto>> deleteTelevision (@PathVariable Long id) {
       televisonService.deleteTelevision(id);
       return ResponseEntity.noContent().build();
    }




//    @Autowired
//    private TelevisionRepository televisionRepo;
//
//    @GetMapping
//    public ResponseEntity<List<Television>> getAllTelevisions() {
//        return ResponseEntity.ok(televisionRepo.findAll());
//    }
//
//    @PostMapping
//    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
//        televisionRepo.save(television);
//        URI uri = URI.create(ServletUriComponentsBuilder.
//                fromCurrentRequest().
//                path("/" + television.getId()).toUriString());
//        return ResponseEntity.created(uri).body(television);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television televisionDetails) {
//        Optional<Television> updateTelevision = televisionRepo.findById(id);
//        if (updateTelevision.isPresent()) {
//            Television newDetailsOfTelevision = updateTelevision.get();
//            newDetailsOfTelevision.setHdr(televisionDetails.getHdr());
//            newDetailsOfTelevision.setAmbiLight(televisionDetails.getAmbiLight());
//            newDetailsOfTelevision.setAvailableSize(televisionDetails.getAvailableSize());
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }

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