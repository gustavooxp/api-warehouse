package com.warehouse.api.dto;

import com.warehouse.api.entity.Shipment;

import java.util.HashSet;
import java.util.Set;

public class ProductCreateDTO {

    private String sku;
    private String name;
    private Set<Shipment> shipments = new HashSet<>();

    public ProductCreateDTO(){

    }

    public ProductCreateDTO(String sku, String name, Set<Shipment> shipments) {
        this.sku = sku;
        this.name = name;
        this.shipments = shipments;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(Set<Shipment> shipments) {
        this.shipments = shipments;
    }
}
