package com.demo.service;

import com.demo.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAll();
    Page<List<ProductEntity>> findAllByName(String name, Pageable pageable);
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity updateProduct(ProductEntity productEntity);
    ProductEntity findById(int id);

    void delete(int id);


}
