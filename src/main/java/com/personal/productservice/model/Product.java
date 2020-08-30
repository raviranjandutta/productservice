package com.personal.productservice.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_details")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", length = 64, nullable = false)
    private String name;
    @Column(name = "brand", length = 64, nullable = false)
    private String brand;


}
