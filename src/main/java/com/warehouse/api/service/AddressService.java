package com.warehouse.api.service;

import com.warehouse.api.dto.AddressCreateDTO;
import com.warehouse.api.dto.AddressCreateDTO;
import com.warehouse.api.entity.Address;
import com.warehouse.api.entity.Address;
import com.warehouse.api.repository.AddressRepository;
import com.warehouse.api.repository.AddressRepository;
import com.warehouse.api.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressCreateDTO convertToDto(Address address) {
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
//        get the address data and pass it to addressCreateDto
        addressCreateDTO.setCity(address.getCity());
        addressCreateDTO.setWarehouse(address.getWarehouse());
        addressCreateDTO.setStreet(address.getStreet());
        return addressCreateDTO;
    }

    public Address convertToEntity(AddressCreateDTO addressCreateDTO) {
        Address address = new Address();
//        get to addressCreateDto data and pass it to address
        address.setCity(addressCreateDTO.getCity());
        address.setWarehouse(addressCreateDTO.getWarehouse());
        address.setStreet(addressCreateDTO.getStreet());
        return address;
    }

    public AddressCreateDTO findById(UUID id) {
//        returns a address entitys
        Address address = addressRepository.findById(id).orElseThrow();
//        method to convert an entity address to addressCreateDto
        AddressCreateDTO addressCreateDTO = convertToDto(address);
        return addressCreateDTO;
    }

    //    method save a address
    public AddressCreateDTO save(AddressCreateDTO addressCreateDTO) {
        Address address = convertToEntity(addressCreateDTO);
        address = addressRepository.save(address);
        return convertToDto(address);
    }

    //    method update a address
    public AddressCreateDTO update(UUID id, AddressCreateDTO addressCreateDTO) {
        Address address = convertToEntity(addressCreateDTO);
        address.setId(id);
        address = addressRepository.save(address);
        return convertToDto(address);
    }

    //    method to delete one address
    public void deleteById(UUID id) {
        addressRepository.deleteById(id);
    }

    //    method to list all address
    public List<AddressCreateDTO> findAll(){
        List<Address> addressList = addressRepository.findAll();
//        create list addressCreateDto
        List<AddressCreateDTO> addressDTO = new ArrayList<>();
//        for each address in the address list convert to dto and add to the dto list
        for (Address address: addressList) {
            addressDTO.add(convertToDto(address));
        }
        return addressDTO;
    }
}
