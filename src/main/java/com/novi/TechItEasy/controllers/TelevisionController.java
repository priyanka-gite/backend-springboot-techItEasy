package com.novi.TechItEasy.controllers;

import com.novi.TechItEasy.model.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/techItEasy")
public class TelevisionController {
    private List<Television> tv;// 1. declare the list

    public TelevisionController() {
        tv = new ArrayList<>();// 2. initialise the list
        Television tele = new Television(); // instantiate the class Television
        tele.setBrandName("onida");//setting the attributes to the instance of television
        tele.setTeleType("LCD");
        tv.add(tele); // 3. adding list to instance of television class
    }

    @GetMapping(value = "/televisions")
    public ResponseEntity getTelevisions() {
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }

    @GetMapping("/televisions/{index}")
    public ResponseEntity getTelevision(@PathVariable int index) {
        if (index >= 0 && index < tv.size()) {
            Television t = tv.get(index); // this i dont understand;
            return new ResponseEntity<>(t, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/televisions")
    public ResponseEntity<Television> addTelevision(@RequestBody Television newTelevison) {
        tv.add(newTelevison);
        return new ResponseEntity<>(newTelevison, HttpStatus.CREATED);
    }
//    @PutMapping("/televisions/{index}")
//    public ResponseEntity<Television> updateTelevision(@PathVariable int index, @RequestBody Television newTele) {
//        if()
//    }

    @DeleteMapping("/televisions/{index}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int index, @RequestBody Television newTele) {
        if (index >= 0 && index < tv.size()) {
            Television t = tv.get(index); // this i dont understand;
            tv.remove(t);
            return new ResponseEntity<>(t, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
