package com.warehouse.api.controller;

import com.warehouse.api.dto.SectionCreateDTO;
import com.warehouse.api.dto.SectionCreateDTO;
import com.warehouse.api.service.SectionService;
import com.warehouse.api.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/section")
//http://localhost:8080/api/v1/section
public class SectionController {
    @Autowired
    SectionService service;

    //    get a section by its id
    @GetMapping("/{id}")
    public SectionCreateDTO findById(@PathVariable ("id") UUID id) {
        return service.findById(id);
    }

    //    get all section
    @GetMapping
    public List<SectionCreateDTO> findAll() {
        return service.findAll();
    }

    //    save one section
    @PostMapping
    public SectionCreateDTO save(@RequestBody SectionCreateDTO sectionCreateDTO) {
        return service.save(sectionCreateDTO);
    }

    //    update one section
    @PutMapping("/{id}")
    public SectionCreateDTO update(@PathVariable("id") UUID id, @RequestBody SectionCreateDTO sectionCreateDTO) {
        return service.update(id, sectionCreateDTO);
    }

    //    delete a section by its id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
