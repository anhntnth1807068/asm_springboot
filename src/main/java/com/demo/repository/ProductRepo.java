package com.demo.repository;

import com.demo.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Id;
import java.util.List;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();

    @Query("select c from ProductEntity c where c.name like %?1%")
    Page<List<ProductEntity>> findAllByName(String name, Pageable pageable);



}
