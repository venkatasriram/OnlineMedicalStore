package com.capg.casestudy.onlinemedicalstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private Boolean isInStock;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
