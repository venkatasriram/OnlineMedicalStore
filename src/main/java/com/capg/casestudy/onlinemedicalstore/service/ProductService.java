package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;

import com.capg.casestudy.onlinemedicalstore.dto.ProductDTO;
import com.capg.casestudy.onlinemedicalstore.entity.Product;
public interface ProductService {
    public Product addProduct(ProductDTO productDTO);
    public Product updateProduct(Product product);
    public void removeProduct(int id);
    public List<Product> viewAllProducts();
    public Product viewProductById(int id);
}