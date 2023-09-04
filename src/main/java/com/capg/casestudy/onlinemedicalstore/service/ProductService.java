package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;
import com.capg.casestudy.onlinemedicalstore.entity.Product;
public interface ProductService {
    public Product addProduct(Product hotel);
    public Product updateProduct(Product product);
    public void removeProduct(int id);
    public List<Product> showAllProducts();
    public Product showProduct(int id);
}