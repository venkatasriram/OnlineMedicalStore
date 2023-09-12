package com.capg.casestudy.onlinemedicalstore.repository;

import com.capg.casestudy.onlinemedicalstore.entity.Cart;
import com.capg.casestudy.onlinemedicalstore.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Optional<Cart> findByUserId(int userId);
}
