package com.warehouse.api.dto;

import com.warehouse.api.entity.Address;
import com.warehouse.api.entity.Section;

import java.util.HashSet;
import java.util.Set;

public class WarehouseCreateDTO {

    private String name;
    private Address address;
    private Set<Section> sections = new HashSet<>();

    public WarehouseCreateDTO(){

    }

    public WarehouseCreateDTO(String name, Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
