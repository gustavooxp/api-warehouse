package com.warehouse.api.service;

import com.warehouse.api.dto.ShipmentCreateDTO;
import com.warehouse.api.entity.Shipment;
import com.warehouse.api.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    public ShipmentCreateDTO convertToDto(Shipment shipment) {
        ShipmentCreateDTO shipmentCreateDTO = new ShipmentCreateDTO();
//        get the shipment data and pass it to shipmentCreateDto
        shipmentCreateDTO.setProducts(shipment.getProducts());
        shipmentCreateDTO.setStatus(shipment.getStatus());
        return shipmentCreateDTO;
    }

    public Shipment convertToEntity(ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = new Shipment();
//        get to shipmentCreateDto data and pass it to shipment
        shipment.setProducts(shipmentCreateDTO.getProducts());
        shipment.setStatus(shipmentCreateDTO.getStatus());
        return shipment;
    }

    public ShipmentCreateDTO findById(UUID id) {
//        returns a shipment entitys
        Shipment shipment = shipmentRepository.findById(id).orElseThrow();
//        method to convert an entity shipment to shipmentCreateDto
        ShipmentCreateDTO shipmentCreateDTO = convertToDto(shipment);
        return shipmentCreateDTO;
    }

//    method save a shipment
    public ShipmentCreateDTO save(ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = convertToEntity(shipmentCreateDTO);
        shipment = shipmentRepository.save(shipment);
        return convertToDto(shipment);
    }

//    method update a shipment
    public ShipmentCreateDTO update(UUID id, ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = convertToEntity(shipmentCreateDTO);
        shipment.setId(id);
        shipment = shipmentRepository.save(shipment);
        return convertToDto(shipment);
    }

//    method to delete one shipment
    public void deleteById(UUID id) {
        shipmentRepository.deleteById(id);
    }

//    method to list all shipments
    public List<ShipmentCreateDTO> findAll() {
        List<Shipment> shipments = shipmentRepository.findAll();
//        create list shipmentCreateDto
        List<ShipmentCreateDTO> shipmentDTO = new ArrayList<>();
//        for each shipment in the shipment list convert to dto and add to the dto list
        for (Shipment shipment : shipments) {
            shipmentDTO.add(convertToDto(shipment));
        }
        return shipmentDTO;
    }
}
