package com.novi.TechItEasy.controller;

import com.novi.TechItEasy.service.WallBracketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/techItEasy/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController (WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }


}
