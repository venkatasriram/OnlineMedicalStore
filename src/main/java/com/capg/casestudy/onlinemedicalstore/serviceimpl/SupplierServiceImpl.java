package com.capg.casestudy.onlinemedicalstore.serviceimpl;

import com.capg.casestudy.onlinemedicalstore.entity.Supplier;
import com.capg.casestudy.onlinemedicalstore.exception.SupplierNotFoundException;
import com.capg.casestudy.onlinemedicalstore.repository.SupplierRepository;
import com.capg.casestudy.onlinemedicalstore.service.SupplierService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return null;
    }
    @Override
    public void removeSupplier(int id) {
        Optional<Supplier> supplier=supplierRepository.findById(id);
        if (supplier.isEmpty()){
            throw new SupplierNotFoundException("supplier not found");
        }
        supplierRepository.delete(supplier.get());
    }
    @Override
    public List<Supplier> showAllSuppliers() {
        return supplierRepository.findAll();
    }
    @Override
    public Supplier showSupplier(int id) {
        Optional<Supplier> supplier=supplierRepository.findById(id);
        if (supplier.isEmpty()){
            throw new SupplierNotFoundException("supplier not found");
        }
        return supplier.get();
    }
}
