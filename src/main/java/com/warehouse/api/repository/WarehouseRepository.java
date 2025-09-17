package com.warehouse.api.repository;

import com.warehouse.api.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {
}
