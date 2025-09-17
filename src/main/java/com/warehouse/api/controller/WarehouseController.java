package com.warehouse.api.controller;

import com.warehouse.api.dto.WarehouseCreateDTO;
import com.warehouse.api.entity.Warehouse;
import com.warehouse.api.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/warehouse")
//http://localhost:8080/api/v1/warehouse
public class WarehouseController {
    @Autowired
    WarehouseService service;

//    get a warehouse by its id
    @GetMapping("/{id}")
    public WarehouseCreateDTO findById(@PathVariable ("id") UUID id ){
        return service.findById(id);
    }

//    get all warehouse
    @GetMapping
    public List<WarehouseCreateDTO> findAll() {
        return service.findAll();
    }

//    save one warehouse
    @PostMapping
    public WarehouseCreateDTO save(@RequestBody WarehouseCreateDTO warehouseCreateDTO) {
        return service.save(warehouseCreateDTO);
    }

//    update one warehouse
    @PutMapping("/{id}")
    public WarehouseCreateDTO update (@PathVariable("id") UUID id, @RequestBody WarehouseCreateDTO warehouseCreateDTO) {
        return service.update(id, warehouseCreateDTO);
    }

//    delete a warehouse by its id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }

}
