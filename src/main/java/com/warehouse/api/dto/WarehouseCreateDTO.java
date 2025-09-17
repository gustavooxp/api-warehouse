package com.warehouse.api.dto;

import com.warehouse.api.entity.Address;
import com.warehouse.api.entity.Section;

import java.util.HashSet;
import java.util.Set;

public class WarehouseCreateDTO {

    private Address address;
    private Set<Section> sections = new HashSet<>();

    public WarehouseCreateDTO(){

    }

    public WarehouseCreateDTO(Address address, Set<Section> sections) {
        this.address = address;
        this.sections = sections;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }
}
