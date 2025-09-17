package com.warehouse.api.controller;

import com.warehouse.api.dto.ProductCreateDTO;
import com.warehouse.api.dto.ProductCreateDTO;
import com.warehouse.api.service.ProductService;
import com.warehouse.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
//http://localhost:8080/api/v1/product
public class ProductController {
    @Autowired
    ProductService service;

    //    get a product by its id
    @GetMapping("/{id}")
    public ProductCreateDTO findById(@PathVariable ("id") UUID id) {
        return service.findById(id);
    }

    //    get all product
    @GetMapping
    public List<ProductCreateDTO> findAll() {
        return service.findAll();
    }

    //    save one product
    @PostMapping
    public ProductCreateDTO save(@RequestBody ProductCreateDTO productCreateDTO) {
        return service.save(productCreateDTO);
    }

    //    update one product
    @PutMapping("/{id}")
    public ProductCreateDTO update(@PathVariable("id") UUID id, @RequestBody ProductCreateDTO productCreateDTO) {
        return service.update(id, productCreateDTO);
    }

    //    delete a product by its id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
