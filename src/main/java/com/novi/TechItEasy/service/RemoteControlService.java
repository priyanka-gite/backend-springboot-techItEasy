package com.novi.TechItEasy.service;

import com.novi.TechItEasy.dto.RemoteControlDto;
import com.novi.TechItEasy.model.RemoteControl;
import com.novi.TechItEasy.repository.RemoteControlRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControlService {

    private final RemoteControlRepository remoteControlRepository;

    public RemoteControlService(RemoteControlRepository remoteControlRepository) {
        this.remoteControlRepository = remoteControlRepository;
    }

    public List<RemoteControlDto> getRemoteControllers() {
        List<RemoteControl> remoteControls= remoteControlRepository.findAll();
        List<RemoteControlDto> remoteControlDtos = new ArrayList<>();

        for (RemoteControl remoteControl : remoteControls) {
            RemoteControlDto remoteControlDto = convertRemoteControlToRemoteControlDto(remoteControl);
            remoteControlDtos.add(remoteControlDto);
        }
        return remoteControlDtos;
    }

    public RemoteControlDto createRemoteControl (RemoteControlDto remoteControlDto) {
                remoteControlRepository.save(convertRemoteControlDtoToRemoteControl(remoteControlDto));
                return remoteControlDto;
    }

//    -------------CONVERSION-----------

    public RemoteControlDto convertRemoteControlToRemoteControlDto(RemoteControl remoteControlData) {
        RemoteControlDto remoteControlDto = new RemoteControlDto();

//  should we setId as well?
        remoteControlDto.setId(remoteControlData.getId());
        remoteControlDto.setBrand(remoteControlData.getBrand());
        remoteControlDto.setBatteryType(remoteControlData.getBatteryType());
        remoteControlDto.setName(remoteControlData.getName());
        remoteControlDto.setOriginalStock(remoteControlData.getOriginalStock());
        remoteControlDto.setPrice(remoteControlData.getPrice());
        remoteControlDto.setCompatibleWith(remoteControlData.getCompatibleWith());

        return remoteControlDto;
    }

    public RemoteControl convertRemoteControlDtoToRemoteControl (RemoteControlDto remoteControlDto) {
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setBatteryType(remoteControlDto.getBatteryType());
        remoteControl.setBrand(remoteControlDto.getBrand());
        remoteControl.setCompatibleWith(remoteControlDto.getCompatibleWith());
        remoteControl.setName(remoteControlDto.getName());
        remoteControl.setTelevision(remoteControl.getTelevision());
        remoteControl.setId(remoteControlDto.getId());
        remoteControl.setOriginalStock(remoteControl.getOriginalStock());
        remoteControl.setPrice(remoteControlDto.getPrice());

     return remoteControl;
    }

}
