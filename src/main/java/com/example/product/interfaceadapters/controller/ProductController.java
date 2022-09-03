package com.example.product.interfaceadapters.controller;

import com.example.product.interfaceadapters.controller.converter.ProductConverter;
import com.example.product.interfaceadapters.controller.model.ProductModel;
import com.example.product.usecase.CreateProductUC;
import com.example.product.usecase.ListProductUC;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(value = "Product")
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private CreateProductUC createProductUC;

    @Autowired
    private ListProductUC listProductUC;

    @GetMapping()
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.ok(ProductConverter.toModels(listProductUC.listAll()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(ProductConverter.toModel(listProductUC.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<Object> createProduct(@RequestBody ProductModel product) {
        createProductUC.execute(ProductConverter.toEntity(product));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
