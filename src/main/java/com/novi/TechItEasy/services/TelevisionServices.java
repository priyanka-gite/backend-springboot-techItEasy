package com.novi.TechItEasy.services;

import com.novi.TechItEasy.dtos.TelevisionDto;
import com.novi.TechItEasy.exceptions.RecordNotFoundException;
import com.novi.TechItEasy.model.Television;
import com.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionServices {

    @Autowired

    // CREATE INSTANCE OF TELE REPOSITORY
    private final TelevisionRepository televisionRepo;

    public TelevisionServices(TelevisionRepository televisionRepo) {
        this.televisionRepo = televisionRepo;
    }

    //    CREATE getTelevisions() METHOD THAT RETURNS THE LIST OF TELEVISIONDTO;
    public List<TelevisionDto> getTelevisions() {
        List<Television> televisions = televisionRepo.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>();
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



    // CREATE convertTelevisionToTelevisionDto() METHOD THAT RETURNS TELEVISIONDTO
    private TelevisionDto convertTelevisionToTelevisionDto(Television televisionData) {

//        CREATE INSTANCE OF OUR TELEVISONDTO CLASS;
        TelevisionDto televisionDto = new TelevisionDto();

//        SET PROPERTIES IN DTO FROM televisionData;
        televisionDto.setId(televisionData.getId());
        televisionDto.setBluetooth(televisionData.getBluetooth());
        televisionDto.setAvailableSize(televisionDto.availableSize);
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


}

