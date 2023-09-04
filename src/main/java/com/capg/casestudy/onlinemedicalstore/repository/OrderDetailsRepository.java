package com.capg.casestudy.onlinemedicalstore.repository;


import com.capg.casestudy.onlinemedicalstore.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
}
