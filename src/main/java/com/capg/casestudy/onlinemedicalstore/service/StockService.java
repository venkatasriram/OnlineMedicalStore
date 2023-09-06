package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;

import com.capg.casestudy.onlinemedicalstore.entity.Product;
import com.capg.casestudy.onlinemedicalstore.entity.Stock;
public interface StockService {
    public Stock addStock(int productId,int quantity);
    public Stock initialStockForProduct(Product product);
    public Stock updateStock(Stock stock);
    public void removeStock(int id);
    public List<Stock> viewAllStocks();
    public Stock viewStockById(int id);
}