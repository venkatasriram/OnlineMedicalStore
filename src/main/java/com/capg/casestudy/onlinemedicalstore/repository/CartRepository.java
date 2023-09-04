package com.capg.casestudy.onlinemedicalstore.repository;

import com.capg.casestudy.onlinemedicalstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
