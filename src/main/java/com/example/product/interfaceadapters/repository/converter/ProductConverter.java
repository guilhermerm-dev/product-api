package com.example.product.interfaceadapters.repository.converter;

import com.example.product.entity.Product;
import com.example.product.interfaceadapters.repository.model.ProductModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductConverter {

    public static ProductModel toRepositoryModel(Product product) {
        return new ProductModel(product.getName(), product.getCode(), product.getCategory());
    }

    public static Optional<Product> toEntity(Optional<ProductModel> product) {
        return Optional.of(new Product(product.get().getName(), product.get().getCode(), product.get().getCategory()));
    }

    public static List<Product> toEntities(List<ProductModel> products) {
        return products.stream().map(product ->
                new Product(product.getName(), product.getCode(), product.getCategory())).collect(Collectors.toList());
    }
}
