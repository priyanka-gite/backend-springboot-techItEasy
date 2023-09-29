package com.novi.TechItEasy.service;

import com.novi.TechItEasy.dto.CiModuleDto;
import com.novi.TechItEasy.exception.RecordNotFoundException;
import com.novi.TechItEasy.model.CiModule;
import com.novi.TechItEasy.model.Television;
import com.novi.TechItEasy.repository.CiModuleRepository;
import com.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;
    private final TelevisionRepository televisionRepo;

    public CiModuleService(CiModuleRepository ciModuleRepository, TelevisionRepository televisionRepo) {
        this.ciModuleRepository = ciModuleRepository;

        this.televisionRepo = televisionRepo;
    }

    public List<CiModuleDto> getAllCiModules() {

//        finding list from repo and assigning to a variable
        List<CiModule> ciModules = ciModuleRepository.findAll();

//        initiating a new dto list
        List<CiModuleDto> ciModuleDtoList = new ArrayList<>();

//      looping through the list of items in repository
        for (CiModule ciModule : ciModules) {
            CiModuleDto ciModuleDto = convertCiModuleToCiModuleDto(ciModule);
            ciModuleDtoList.add(ciModuleDto);
        }
        return ciModuleDtoList;

    }

    public CiModuleDto createCiModule(CiModuleDto ciModuleDtoData) {
        ciModuleRepository.save(convertCiModuleDtoToCiModuleEntity(ciModuleDtoData));
        return ciModuleDtoData;
    }

    public void assignCiModuletoTelevision(List<Long> televisionsId, Long ciModuleId) {
        Optional<CiModule> ciModule1 = ciModuleRepository.findById(ciModuleId);

        if(ciModule1.isPresent()) {
            CiModule ciModule = ciModule1.get();

            List<Television> teleList = new ArrayList<>();

            for (Long oneTeleId : televisionsId) {
                Optional<Television> television1 = televisionRepo.findById(oneTeleId);
                if (television1.isPresent()) {
                    Television tele = television1.get();
                    teleList.add(tele);
                }
            }
            ciModule.setTelevisions(teleList);
            ciModuleRepository.save(ciModule);
        }
    }

//    ----------------- CONVERSION--------------------

    private CiModuleDto convertCiModuleToCiModuleDto(CiModule ciModule) {

        CiModuleDto ciModuleDto = new CiModuleDto();
        ciModuleDto.setId(ciModule.getId());
        ciModuleDto.setName(ciModule.getName());
        ciModuleDto.setPrice(ciModule.getPrice());
        ciModuleDto.setType(ciModule.getType());
        return ciModuleDto;
    }

    private CiModule convertCiModuleDtoToCiModuleEntity(CiModuleDto ciModuleDto) {
        CiModule ciModule = new CiModule();
        ciModule.setId(ciModuleDto.getId());
        ciModule.setName(ciModuleDto.getName());
        ciModule.setPrice(ciModuleDto.getPrice());
        ciModule.setType(ciModuleDto.getType());
        ciModule.setTelevisions(ciModuleDto.getTelevisions());
        return ciModule;
    }
}
