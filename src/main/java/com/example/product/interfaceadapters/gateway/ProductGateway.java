package com.example.product.interfaceadapters.gateway;

import com.example.product.entity.Product;
import com.example.product.interfaceadapters.repository.ProductRepository;
import com.example.product.interfaceadapters.repository.converter.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductGateway implements ProductRepositoryGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.saveAndFlush(ProductConverter.toRepositoryModel(product));
    }

    @Override
    public List<Product> listAll() {
        return ProductConverter.toEntities(productRepository.findAll());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return ProductConverter.toEntity(productRepository.findById(id));
    }

    @Override
    public boolean findByCodeAndName(String code, String name) {
        return productRepository.findByCodeAndName(code, name);
    }
}
