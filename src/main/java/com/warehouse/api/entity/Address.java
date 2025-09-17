package com.warehouse.api.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;
    @Column(nullable = false, updatable = false)
    private String street;
    @Column(nullable = false,updatable = false)
    private String city;

    @OneToOne(mappedBy = "address")
    private Warehouse warehouse;

    public Address (){
    }

    public Address(UUID id, String street, String city, Warehouse warehouse) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.warehouse = warehouse;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
