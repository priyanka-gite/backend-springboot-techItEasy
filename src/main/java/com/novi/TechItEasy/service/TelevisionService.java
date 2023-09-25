package com.novi.TechItEasy.service;

import com.novi.TechItEasy.dto.RemoteControlDto;
import com.novi.TechItEasy.dto.TelevisionDto;
import com.novi.TechItEasy.exception.RecordNotFoundException;
import com.novi.TechItEasy.model.RemoteControl;
import com.novi.TechItEasy.model.Television;
import com.novi.TechItEasy.repository.RemoteControlRepository;
import com.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    // CREATE INSTANCE OF TELE REPOSITORY
    private final TelevisionRepository televisionRepo;
    private final RemoteControlRepository remoteControlRepository;

    public TelevisionService(TelevisionRepository televisionRepo, RemoteControlRepository remoteControlRepository) {
        this.televisionRepo = televisionRepo;
        this.remoteControlRepository = remoteControlRepository;
    }

    //    CREATE getTelevisions() METHOD THAT RETURNS THE LIST OF TELEVISIONDTO;
    public List<TelevisionDto> getTelevisions() {
        List<Television> televisions;
        televisions = televisionRepo.findAll();
        List<TelevisionDto> televisionDtos;
        televisionDtos = new ArrayList<>();
        for (Television television : televisions) {
            TelevisionDto televisionDto = convertTelevisionToTelevisionDto(television);
            televisionDtos.add(televisionDto);
        }
        return televisionDtos;
    }


    public TelevisionDto createTelevision(TelevisionDto televisionDto) {
        televisionRepo.save(convertTelevisionDtoToTelevision(televisionDto));
        return televisionDto;
    }

    public TelevisionDto updateTelevision(Long id) {
        Optional<Television> myTelevision = televisionRepo.findById(id);
        if (myTelevision.isPresent()) {
            Television television = myTelevision.get();
            return convertTelevisionToTelevisionDto(television);
        } else {
            throw new RecordNotFoundException("Television not found");
        }
    }

    public void deleteTelevision(Long id) {
        Optional<Television> myTelevision = televisionRepo.findById(id);
        if (myTelevision.isPresent()) {
            Television tele = myTelevision.get();
            televisionRepo.delete(tele);

        } else {
            throw new RecordNotFoundException("Television not found");
        }
    }

    public void assignRemoteControllerToTelevision(Long televisionId, Long remoteControlId) {
        Optional<Television> television = televisionRepo.findById(televisionId);
        Optional<RemoteControl> remoteControl = remoteControlRepository.findById(remoteControlId);
        if (television.isPresent() && remoteControl.isPresent()) {
            Television tele = television.get();
            RemoteControl remoteControl1 = remoteControl.get();
            tele.setRemoteControl(remoteControl1);
            televisionRepo.save(tele);
        }else {
            throw new RecordNotFoundException("Television or Remote Controller Not Found. Try again with new Id");
        }
    }

//    ----------------CONVERSION---------------

    // CREATE convertTelevisionToTelevisionDto() METHOD THAT RETURNS TELEVISIONDTO
    private TelevisionDto convertTelevisionToTelevisionDto(Television televisionData) {

//        CREATE INSTANCE OF OUR TELEVISONDTO CLASS;
        TelevisionDto televisionDto = new TelevisionDto();

//        SET PROPERTIES IN DTO FROM televisionData;
        televisionDto.setId(televisionData.getId());
        televisionDto.setBluetooth(televisionData.getBluetooth());
        televisionDto.setAvailableSize(televisionDto.getAvailableSize());
        televisionDto.setAmbiLight(televisionData.getAmbiLight());
        televisionDto.setBrand(televisionData.getBrand());
        televisionDto.setHdr(televisionData.getHdr());
        televisionDto.setName(televisionData.getName());
        televisionDto.setPrice(televisionData.getPrice());
        televisionDto.setRefreshRate(televisionData.getRefreshRate());
        televisionDto.setOriginalStock(televisionData.getOriginalStock());
        televisionDto.setScreenQuality(televisionData.getScreenQuality());
        televisionDto.setSold(televisionData.getSold());
        televisionDto.setType(televisionData.getType());
        televisionDto.setWifi(televisionData.getWifi());
        televisionDto.setSmartTv(televisionData.getSmartTv());
        televisionDto.setScreenType(televisionData.getScreenType());
        televisionDto.setVoiceControl(televisionData.getVoiceControl());

        return televisionDto;
    }

    private Television convertTelevisionDtoToTelevision(TelevisionDto televisiondto) {
        Television newtelevision = new Television();
        newtelevision.setId(televisiondto.getId());
        newtelevision.setBluetooth(televisiondto.getBluetooth());
        newtelevision.setAvailableSize(televisiondto.getAvailableSize());
        newtelevision.setAmbiLight(televisiondto.getAmbiLight());
        newtelevision.setBrand(televisiondto.getBrand());
        newtelevision.setHdr(televisiondto.getHdr());
        newtelevision.setName(televisiondto.getName());
        newtelevision.setPrice(televisiondto.getPrice());
        newtelevision.setRefreshRate(televisiondto.getRefreshRate());
        newtelevision.setOriginalStock(televisiondto.getOriginalStock());
        newtelevision.setScreenQuality(televisiondto.getScreenQuality());
        newtelevision.setSold(televisiondto.getSold());
        newtelevision.setType(televisiondto.getType());
        newtelevision.setWifi(televisiondto.getWifi());
        newtelevision.setSmartTv(televisiondto.getSmartTv());
        newtelevision.setScreenType(televisiondto.getScreenType());
        newtelevision.setVoiceControl(televisiondto.getVoiceControl());
        return newtelevision;
    }

//    To convert dto to entity id are still not made. once an for ex. television is created an id will be generated.


}

