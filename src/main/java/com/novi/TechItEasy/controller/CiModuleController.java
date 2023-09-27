package com.novi.TechItEasy.controller;

import com.novi.TechItEasy.dto.CiModuleDto;
import com.novi.TechItEasy.dto.IdInputDto;
import com.novi.TechItEasy.dto.IdInputListDto;
import com.novi.TechItEasy.service.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/techItEasy/cimodules")
public class CiModuleController {

    private final CiModuleService ciModuleService;

    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;

    }

    @GetMapping
    public ResponseEntity<List<CiModuleDto>> getAllCiModules() {
        List<CiModuleDto> ciModuleDtoList;
        ciModuleDtoList = ciModuleService.getAllCiModules();
        return ResponseEntity.ok(ciModuleDtoList);
    }

    @PostMapping
    public ResponseEntity<Object> createciModule(@RequestBody CiModuleDto ciModuleDto, BindingResult result) {
        if (result.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : result.getFieldErrors()) {
                sb.append(fe.getField());
                sb.append(":");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        } else {
            ciModuleService.createCiModule(ciModuleDto);
            URI uri = URI.create(ServletUriComponentsBuilder.
                    fromCurrentRequest().
                    path("/" + ciModuleDto.getId()).toUriString());
            return ResponseEntity.created(uri).body(ciModuleDto);
        }
    }

    @PutMapping("/{cimoduleid}/televisions")
    public ResponseEntity assignciModuleToTelevision(@PathVariable Long cimoduleid, @RequestBody IdInputListDto idList) {
        ciModuleService.assignCiModuletoTelevision(idList.getIds(), cimoduleid);
        return ResponseEntity.ok().build();
    }
}
