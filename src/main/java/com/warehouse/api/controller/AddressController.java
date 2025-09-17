package com.warehouse.api.controller;

import com.warehouse.api.dto.ProductCreateDTO;
import com.warehouse.api.dto.AddressCreateDTO;
import com.warehouse.api.service.ProductService;
import com.warehouse.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")
//http://localhost:8080/api/v1/address
public class AddressController {
    @Autowired
    AddressService service;

    //    get a address by its id
    @GetMapping("/{id}")
    public AddressCreateDTO findById(@PathVariable ("id") UUID id) {
        return service.findById(id);
    }

    //    get all address
    @GetMapping
    public List<AddressCreateDTO> findAll() {
        return service.findAll();
    }

    //    save one address
    @PostMapping
    public AddressCreateDTO save(@RequestBody AddressCreateDTO addressCreateDTO) {
        return service.save(addressCreateDTO);
    }

    //    update one address
    @PutMapping("/{id}")
    public AddressCreateDTO update(@PathVariable("id") UUID id, @RequestBody AddressCreateDTO addressCreateDTO) {
        return service.update(id, addressCreateDTO);
    }

    //    delete a address by its id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
