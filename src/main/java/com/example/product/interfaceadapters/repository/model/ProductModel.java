package com.example.product.interfaceadapters.repository.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class ProductModel {

    public ProductModel() {

    }

    public ProductModel(String name, String code, String category) {
        this.name = name;
        this.code = code;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PRODUCT_SEQUENCE")
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    @NotEmpty(message = "name cannot be empty")
    @NotNull(message = "name cannot be null")
    private String name;

    @Column(name = "code")
    @NotEmpty(message = "code cannot be empty")
    @NotNull(message = "code cannot be null")
    private String code;

    @Column(name = "category")
    @NotEmpty(message = "category cannot be empty")
    @NotNull(message = "category cannot be null")
    private String category;

    public String getName() {
        return this.name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
