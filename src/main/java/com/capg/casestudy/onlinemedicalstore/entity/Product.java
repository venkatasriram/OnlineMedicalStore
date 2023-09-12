package com.capg.casestudy.onlinemedicalstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String productName;
    private String description;
    private String expDate;
    private String mfgDate;
    private double price;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Cart> cart;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<OrderDetails> orderDetails;
}
