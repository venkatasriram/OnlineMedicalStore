package com.capg.casestudy.onlinemedicalstore.repository;


import com.capg.casestudy.onlinemedicalstore.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
