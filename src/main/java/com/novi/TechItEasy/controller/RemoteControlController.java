package com.novi.TechItEasy.controller;

import com.novi.TechItEasy.dto.RemoteControlDto;
import com.novi.TechItEasy.service.RemoteControlService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/techItEasy/remotecontrollers")
public class RemoteControlController {

    private final RemoteControlService remoteControlService;

    public RemoteControlController(RemoteControlService remoteControlService) {
        this.remoteControlService = remoteControlService;
    }

    @GetMapping
    public ResponseEntity<List<RemoteControlDto>> getAllRemoteControllers() {
        List<RemoteControlDto> remoteControlsList;
        remoteControlsList = remoteControlService.getRemoteControllers();
        return ResponseEntity.ok(remoteControlsList);
    }

    @PostMapping
    public ResponseEntity<Object> createRemote (@RequestBody RemoteControlDto remoteControlDto,  BindingResult br) {
        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField());
                sb.append(":");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return ResponseEntity.badRequest().body(sb.toString());
        } else{
            remoteControlService.createRemoteControl(remoteControlDto);
            URI uri = URI.create(ServletUriComponentsBuilder.
                    fromCurrentRequest().
                    path("/" + remoteControlDto.getId()).toUriString());
            return ResponseEntity.created(uri).body(remoteControlDto);
        }
    }

}
