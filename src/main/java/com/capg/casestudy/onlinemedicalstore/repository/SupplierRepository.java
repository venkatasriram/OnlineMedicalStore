package com.capg.casestudy.onlinemedicalstore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.capg.casestudy.onlinemedicalstore.entity.Supplier;
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
   @Query("select a from Supplier a where supplierName=?1")
   Optional<Supplier> findUser(String name);
}