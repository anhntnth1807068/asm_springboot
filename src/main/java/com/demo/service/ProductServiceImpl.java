package com.demo.service;

import com.demo.entity.ProductEntity;
import com.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Page<List<ProductEntity>> findAllByName(String name, Pageable pageable) {
        return productRepo.findAllByName(name, pageable);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepo.save(productEntity);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public ProductEntity findById(int id) {
        ProductEntity productEntity = productRepo.findById(id).orElse(null);
        return productEntity;

    }
    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepo.save(productEntity);
    }
}
