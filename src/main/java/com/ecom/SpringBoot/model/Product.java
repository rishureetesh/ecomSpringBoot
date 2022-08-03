package com.ecom.SpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_description", nullable = false)
    private String description;

    @Column(name = "total_quantity", nullable = false)
    private long quantity;

    @Column(name = "product_price", nullable = false)
    private long price;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductCategory productCategory;
}
