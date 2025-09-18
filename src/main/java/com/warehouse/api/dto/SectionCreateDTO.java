package com.warehouse.api.dto;

import com.warehouse.api.entity.Warehouse;

public class SectionCreateDTO {
    private String code;
    private Warehouse warehouse;


    public SectionCreateDTO(){

    }

    public SectionCreateDTO(String code, Warehouse warehouse) {
        this.code = code;
        this.warehouse = warehouse;
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
