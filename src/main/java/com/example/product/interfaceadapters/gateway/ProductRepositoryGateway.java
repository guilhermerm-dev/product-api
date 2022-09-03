package com.example.product.interfaceadapters.gateway;

import com.example.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryGateway {
    void createProduct(Product product);

    List<Product> listAll();

    Optional<Product> findById(Long id);

    boolean findByCodeAndName(String code, String name);
}
