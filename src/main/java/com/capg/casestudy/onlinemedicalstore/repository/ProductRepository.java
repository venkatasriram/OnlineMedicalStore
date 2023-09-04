package com.capg.casestudy.onlinemedicalstore.repository;

import com.capg.casestudy.onlinemedicalstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
