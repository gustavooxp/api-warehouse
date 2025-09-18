package com.warehouse.api.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false,updatable = false)
    private ShipmentEnum status;

    @ManyToMany
    @JoinTable(name = "shipment_products", joinColumns = @JoinColumn(name = "shipment_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public Shipment(){

    }

    public Shipment(UUID id, ShipmentEnum status, Set<Product> products) {
        this.id = id;
        this.status = status;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ShipmentEnum getStatus() {
        return status;
    }

    public void setStatus(ShipmentEnum status) {
        this.status = status;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
