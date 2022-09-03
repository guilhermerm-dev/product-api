package com.example.product.integration;

import com.example.product.integration.config.RepositoryIntegrationTestConfiguration;
import com.example.product.interfaceadapters.repository.ProductRepository;
import com.example.product.interfaceadapters.repository.model.ProductModel;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductRepositoryIntegrationTest extends RepositoryIntegrationTestConfiguration {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    public void test() {
        insertUsers();
        List<ProductModel> products = productRepository.findAll();
        Assert.assertEquals(products.size(), 4);
    }


    private void insertUsers() {
        productRepository.save(new ProductModel("SAMPLE_PRODUCT1", "1", "CATEGORY1"));
        productRepository.save(new ProductModel("SAMPLE_PRODUCT2", "2", "CATEGORY2"));
        productRepository.save(new ProductModel("SAMPLE_PRODUCT3", "3", "CATEGORY3"));
        productRepository.save(new ProductModel("SAMPLE_PRODUCT4", "4", "CATEGORY4"));
        productRepository.flush();
    }
}
