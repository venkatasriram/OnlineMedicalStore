package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;
import com.capg.casestudy.onlinemedicalstore.entity.Stock;
public interface StockService {
    public Stock addStock(Stock stock);
    public Stock updateStock(Stock stock);
    public void removeStock(int id);
    public List<Stock> showAllStocks();
    public Stock showStock(int id);
}