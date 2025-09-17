package com.warehouse.api.service;

import com.warehouse.api.dto.WarehouseCreateDTO;
import com.warehouse.api.entity.Warehouse;
import com.warehouse.api.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarehouseCreateDTO findById(UUID id) {
//        returns a warehouse entitys
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow();
//        method to convert an entity warehouse to WarehouseCreateDTO
        WarehouseCreateDTO warehouseCreateDTO = convertToDto(warehouse);
        return warehouseCreateDTO;
    }

//    method to save a warehouses
    public WarehouseCreateDTO save(WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = convertToEntity(warehouseCreateDTO);
        warehouse = warehouseRepository.save(warehouse);
        return convertToDto(warehouse);
    }

//    method to update a warehouses
public WarehouseCreateDTO update(UUID id, WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = convertToEntity(warehouseCreateDTO);
        warehouse.setId(id);
        warehouse = warehouseRepository.save(warehouse);
        return convertToDto(warehouse);
}

//    method to delete one warehouse
    public void deleteById(UUID id) {
        warehouseRepository.deleteById(id);
    }

//    method to list all warehouses
    public List<WarehouseCreateDTO> findAll() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
//        create list warehouseCreateDto
        List<WarehouseCreateDTO> warehouseDTO = new ArrayList<>();
//        for each warehouse in the warehouse list convert to dto and add to the dto list
        for (Warehouse warehouse : warehouses) {
            warehouseDTO.add(convertToDto(warehouse));
        }
        return warehouseDTO;
    }

    public WarehouseCreateDTO convertToDto(Warehouse warehouse) {
        WarehouseCreateDTO warehouseCreateDTO = new WarehouseCreateDTO();
//        get the warehouse data and pass it to warehouseCreateDto
        warehouseCreateDTO.setAddress(warehouse.getAddress());
        warehouseCreateDTO.setSections(warehouse.getSections());
        return warehouseCreateDTO;
    }

    public Warehouse convertToEntity(WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = new Warehouse();
//        get the warehouseCreateDto data and pass it to warehouse
        warehouse.setAddress(warehouseCreateDTO.getAddress());
        warehouse.setSections(warehouseCreateDTO.getSections());
        return warehouse;
    }

}
