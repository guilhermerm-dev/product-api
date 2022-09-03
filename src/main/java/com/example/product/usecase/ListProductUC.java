package com.example.product.usecase;

import com.example.product.entity.Product;

import java.util.List;

public interface ListProductUC {
    List<Product> listAll();

    Product findById(Long id);
}
