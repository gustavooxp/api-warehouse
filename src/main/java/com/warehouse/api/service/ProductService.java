package com.warehouse.api.service;

import com.warehouse.api.dto.ProductCreateDTO;
import com.warehouse.api.entity.Product;
import com.warehouse.api.repository.ProductRepository;
import com.warehouse.api.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductCreateDTO convertToDto(Product product) {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
//        get the product data and pass it to productCreateDto
        productCreateDTO.setName(product.getName());
        productCreateDTO.setSku(product.getSku());
        return productCreateDTO;
    }

    public Product convertToEntity(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
//        get to productCreateDto data and pass it to product
        product.setName(productCreateDTO.getName());
        product.setSku(productCreateDTO.getSku());
        return product;
    }

    public ProductCreateDTO findById(UUID id) {
//        returns a product entitys
        Product product = productRepository.findById(id).orElseThrow();
//        methodo to convert an entity product to productCreateDto
        ProductCreateDTO productCreateDTO = convertToDto(product);
        return productCreateDTO;
    }

//    method save a product
    public ProductCreateDTO save(ProductCreateDTO productCreateDTO) {
        Product product = convertToEntity(productCreateDTO);
        product = productRepository.save(product);
        return convertToDto(product);
    }

//    method update a product
    public ProductCreateDTO update(UUID id, ProductCreateDTO productCreateDTO) {
        Product product = convertToEntity(productCreateDTO);
        product.setId(id);
        product = productRepository.save(product);
        return convertToDto(product);
    }

//    method to delete one product
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

//    method to list all products
    public List<ProductCreateDTO> findAll(){
        List<Product> products = productRepository.findAll();
//        create list productCreateDto
        List<ProductCreateDTO> productDTO = new ArrayList<>();
//        for each product in the product list convert to dto and add to the dto list
        for (Product product : products) {
            productDTO.add(convertToDto(product));
        }
        return productDTO;
    }
}
