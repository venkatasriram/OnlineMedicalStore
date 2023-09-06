package com.capg.casestudy.onlinemedicalstore.controller;

import com.capg.casestudy.onlinemedicalstore.entity.Supplier;
import com.capg.casestudy.onlinemedicalstore.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/supplier/")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @PostMapping("addSupplier/")
    public Supplier addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }
    @GetMapping("viewSupplier/")
    public Supplier viewSupplier(@RequestParam("supplierId") int id){
        return supplierService.showSupplier(id);
    }
    @GetMapping("viewAllSuppliers/")
    public List<Supplier> viewAllSuppliers(){
        return supplierService.showAllSuppliers();
    }
    @DeleteMapping("deleteSupplier/")
    public void deleteSupplier(@RequestParam("supplierId") int id){
        supplierService.removeSupplier(id);
    }
}
