package com.warehouse.api.controller;

import com.warehouse.api.dto.ShipmentCreateDTO;
import com.warehouse.api.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shipment")
//http://localhost:8080/api/v1/shipment
public class ShipmentController {
    @Autowired
    ShipmentService service;

//    get a shipment by its id
    @GetMapping("/{id}")
    public ShipmentCreateDTO findById(@PathVariable ("id") UUID id) {
        return service.findById(id);
    }

//    get all shipment
    @GetMapping
    public List<ShipmentCreateDTO> findAll() {
        return service.findAll();
    }

//    save one shipment
    @PostMapping
    public ShipmentCreateDTO save(@RequestBody ShipmentCreateDTO shipmentCreateDTO) {
        return service.save(shipmentCreateDTO);
    }

//    update one shipment
    @PutMapping("/{id}")
    public ShipmentCreateDTO update(@PathVariable("id") UUID id, @RequestBody ShipmentCreateDTO shipmentCreateDTO) {
        return service.update(id, shipmentCreateDTO);
    }

//    delete a shipment by its id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
