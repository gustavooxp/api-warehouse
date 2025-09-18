package com.warehouse.api.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false, updatable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


    public Section (){

    }

    public Section(UUID id, String code, Warehouse warehouse) {
        this.id = id;
        this.code = code;
        this.warehouse = warehouse;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
