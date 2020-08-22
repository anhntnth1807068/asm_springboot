package com.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "categoryid")
    private Integer categoryid;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private Integer quantity;

    //many to one: EAGER
    //one to one: EAGER
    //many to many: Lazy
    //one to many: Lazy

    @ManyToOne() //EAGER
    @JoinColumn(name = "categoryid", insertable = false, updatable = false)
    private CategoryEntity category;

}
