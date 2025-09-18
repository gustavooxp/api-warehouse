package com.warehouse.api.service;

import com.warehouse.api.dto.SectionCreateDTO;
import com.warehouse.api.dto.ShipmentCreateDTO;
import com.warehouse.api.entity.Section;
import com.warehouse.api.repository.SectionRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public SectionCreateDTO convertToDto(Section section) {
        SectionCreateDTO sectionCreateDTO = new SectionCreateDTO();
//        get the section data and pass it to sectionCreateDto
        sectionCreateDTO.setCode(section.getCode());
        sectionCreateDTO.setWarehouse(section.getWarehouse());
        return sectionCreateDTO;
    }

    public Section convertToEntity(SectionCreateDTO sectionCreateDTO) {
        Section section = new Section();
//        get the sectionCreateDto data and pass it to section
        section.setCode(sectionCreateDTO.getCode());
        section.setWarehouse(sectionCreateDTO.getWarehouse());
        return section;
    }

    public SectionCreateDTO findById(UUID id) {
//        returns a section entitys
        Section section = sectionRepository.findById(id).orElseThrow();
//        method to convert an entity section to sectionCreateDTO
        SectionCreateDTO sectionCreateDTO = convertToDto(section);
        return sectionCreateDTO;
    }

//    method save a section
    public SectionCreateDTO save(SectionCreateDTO sectionCreateDTO) {
        Section section = convertToEntity(sectionCreateDTO);
        section = sectionRepository.save(section);
        return convertToDto(section);
    }

//    method update a section
    public SectionCreateDTO update(UUID id, SectionCreateDTO sectionCreateDTO) {
        Section section = convertToEntity(sectionCreateDTO);
        section.setId(id);
        section = sectionRepository.save(section);
        return convertToDto(section);
    }

//    method to delete one section
    public void deleteById(UUID id) {
        sectionRepository.deleteById(id);
    }

//    method to list all sections
    public List<SectionCreateDTO> findAll() {
        List<Section> sections = sectionRepository.findAll();
//        create list sectionCreateDto
        List<SectionCreateDTO> sectionDTO = new ArrayList<>();
//        for each section in the section list convert to dto and add to the dto list
        for (Section section : sections) {
            sectionDTO.add(convertToDto(section));
        }
        return sectionDTO;
    }
}

