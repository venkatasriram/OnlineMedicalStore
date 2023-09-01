package com.capg.casestudy.onlinemedicalstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private Boolean isInStock;
    private int quantity;
    @JoinColumn(name = "product_id")
    private Product product;
}
