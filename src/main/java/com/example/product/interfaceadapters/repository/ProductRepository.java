package com.example.product.interfaceadapters.repository;

import com.example.product.interfaceadapters.repository.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    @Query(value = "SELECT EXISTS(SELECT 1 FROM store.product WHERE TRIM(LOWER(\"code\")) = TRIM(LOWER(:productCode)) and " +
            "TRIM(LOWER(\"name\")) = TRIM(LOWER(:name)) and is_Deleted = false)", nativeQuery = true)
    boolean findByCodeAndName(String productCode, String name);
}
