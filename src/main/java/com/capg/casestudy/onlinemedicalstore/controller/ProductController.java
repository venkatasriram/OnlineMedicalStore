package com.capg.casestudy.onlinemedicalstore.controller;

import com.capg.casestudy.onlinemedicalstore.dto.ProductDTO;
import com.capg.casestudy.onlinemedicalstore.entity.Product;
import com.capg.casestudy.onlinemedicalstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("add-product/")
    public Product addProduct(ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }
    @GetMapping("view-product/")
    public Product viewProductById(@RequestParam("productId") int id){
        return productService.viewProductById(id);
    }
    @GetMapping("viewAll-products/")
    public List<Product> viewAllProducts(){
        return productService.viewAllProducts();
    }
    @DeleteMapping("delete-product/")
    public void removeProduct(@RequestParam("productId") int id){
        productService.removeProduct(id);
    }
    @PutMapping("update-product/")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
