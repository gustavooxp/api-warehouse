package com.warehouse.api.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column (nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false,updatable = false)
    private String sku;
    @Column(nullable = false,updatable = false)
    private String name;

    @ManyToMany(mappedBy = "products")
    private Set<Shipment> shipments = new HashSet<>();

    public Product() {

    }

    public Product(UUID id, String sku, String name, Set<Shipment> shipments) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.shipments = shipments;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
