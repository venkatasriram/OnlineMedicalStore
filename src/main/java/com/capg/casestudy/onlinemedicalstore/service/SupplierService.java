package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;
import com.capg.casestudy.onlinemedicalstore.entity.Supplier;

public interface SupplierService {
public Supplier addSupplier(Supplier supplier);
public Supplier updateSupplier(Supplier supplier);
public void removeSupplier(int id);
public List<Supplier> showAllSuppliers();
public Supplier showSupplier(int id);
}