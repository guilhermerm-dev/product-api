package com.example.product.interfaceadapters.controller.converter;

import com.example.product.entity.Product;
import com.example.product.interfaceadapters.controller.model.ProductModel;

import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    public static Product toEntity(ProductModel productModel) {
        return new Product(productModel.getName(), productModel.getCode(), productModel.getCategory());
    }

    public static List<ProductModel> toModels(List<Product> products) {
        return products.stream().map(product -> new
                ProductModel(product.getName(), product.getCode(), product.getCategory())).collect(Collectors.toList());
    }

    public static ProductModel toModel(Product product) {
        return new ProductModel(product.getName(), product.getCode(), product.getCategory());
    }
}
