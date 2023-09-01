package com.capg.casestudy.onlinemedicalstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String supplierName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<Product> product= new ArrayList<>();
}
