package com.warehouse.api.dto;

import com.warehouse.api.entity.Warehouse;

public class SectionCreateDTO {
    private Warehouse warehouse;


    public SectionCreateDTO(){

    }

    public SectionCreateDTO(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
