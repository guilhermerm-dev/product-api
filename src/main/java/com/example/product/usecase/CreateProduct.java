package com.example.product.usecase;


import com.example.product.entity.Product;
import com.example.product.interfaceadapters.gateway.ProductRepositoryGateway;
import com.example.product.usecase.exception.ProductAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProduct implements CreateProductUC {

    @Autowired
    private ProductRepositoryGateway productRepositoryGateway;

    public void execute(Product product) {
        if (doesTheProductAlreadyExist(product.getCode(), product.getName()))
            throw new ProductAlreadyExistException(String.format("Product code %s and name %s already exist",
                    product.getCode(), product.getName()));

        productRepositoryGateway.createProduct(product);
    }

    private boolean doesTheProductAlreadyExist(String code, String name) {
        return productRepositoryGateway.findByCodeAndName(code, name);
    }
}
