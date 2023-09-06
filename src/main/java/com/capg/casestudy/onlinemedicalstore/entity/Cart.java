package com.capg.casestudy.onlinemedicalstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private double totalPrice;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<Product> product=new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;
}
