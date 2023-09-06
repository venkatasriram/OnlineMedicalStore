package com.capg.casestudy.onlinemedicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.casestudy.onlinemedicalstore.entity.Stock;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    Optional<Stock> findByProductId(int productId);
}