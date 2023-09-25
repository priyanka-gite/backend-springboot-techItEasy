//package com.novi.TechItEasy.service;
//
//import com.novi.TechItEasy.dto.CiModuleDto;
//import com.novi.TechItEasy.model.CiModule;
//import com.novi.TechItEasy.repository.CiModuleRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CiModuleService {
//
//    private final CiModuleRepository ciModuleRepository;
//
//    public CiModuleService(CiModuleRepository ciModuleRepository) {
//        this.ciModuleRepository = ciModuleRepository;
//    }
//
//    public List<CiModuleDto> getAllCiModules() {
//
////        finding list from repo and assigning to a variable
//        List<CiModule> ciModules;
//        ciModules = ciModuleRepository.findAll();
//
////        initiating a new dto list
//        List<CiModuleDto> ciModuleDtoList;
//        ciModuleDtoList = new ArrayList<>();
//
////        looping through the list of items in repository
//        for (CiModule ciModule : ciModules) {
//            CiModuleDto ciModuleDto = convertCiModuleToCiModuleDto(ciModule);
//            ciModuleDtoList.add(ciModuleDto);
//        }
//        return ciModuleDtoList;
//
//    }
//
//    public CiModuleDto createCiModule(CiModuleDto ciModuleDtoData) {
//        ciModuleRepository.save(convertCiModuleToCiModuleDto(ciModuleDtoData));
//        return ciModuleDtoData;
//    }
//
//    private CiModuleDto convertCiModuleToCiModuleDto(CiModule ciModuleData) {
//        CiModuleDto ciModuleDto = new CiModuleDto();
//        ciModuleDto.setName(ciModuleData.getName());
//        ciModuleDto.setPrice(ciModuleData.getPrice());
//        ciModuleDto.setType(ciModuleData.getType());
//        return ciModuleDto;
//    }
//
//
//}
