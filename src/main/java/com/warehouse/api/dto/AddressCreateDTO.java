package com.warehouse.api.dto;

import com.warehouse.api.entity.Warehouse;

public class AddressCreateDTO {

    private String street;
    private String city;
    private Warehouse warehouse;


    public AddressCreateDTO() {

    }

    public AddressCreateDTO(String street, String city, Warehouse warehouse) {
        this.street = street;
        this.city = city;
        this.warehouse = warehouse;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}


