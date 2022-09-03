package com.example.product.usecase;

import com.example.product.entity.Product;
import com.example.product.interfaceadapters.gateway.ProductRepositoryGateway;
import com.example.product.usecase.exception.ProductNotFoundException;
import com.example.product.usecase.exception.ProductsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ListProduct implements ListProductUC {

    @Autowired
    private ProductRepositoryGateway productRepositoryGateway;

    @Override
    public List<Product> listAll() {
        List<Product> products = productRepositoryGateway.listAll();

        if (products.size() == 0)
            throw new ProductsNotFoundException("No products were found!");

        return products;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepositoryGateway.findById(id);

        if (product.isPresent())
            return product.get();

        throw new ProductNotFoundException(String.format("Product id %d does not exist", id));
    }
}
