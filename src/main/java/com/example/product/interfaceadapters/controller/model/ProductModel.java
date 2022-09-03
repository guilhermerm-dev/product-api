package com.example.product.interfaceadapters.controller.model;

public class ProductModel {

    public ProductModel(String name, String code, String category) {
        this.name = name;
        this.code = code;
        this.category = category;
    }

    private String name;
    private String code;
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
