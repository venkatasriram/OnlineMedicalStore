package com.capg.casestudy.onlinemedicalstore.controller;

import com.capg.casestudy.onlinemedicalstore.entity.Stock;
import com.capg.casestudy.onlinemedicalstore.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stock/")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("add-stock/")
    public Stock addStock(int productId,int quantity){
        return stockService.addStock(productId,quantity);
    }
    @GetMapping("view-all-stocks")
    public List<Stock> viewAllStocks(){
        return stockService.viewAllStocks();
    }
    @GetMapping("view-stock-by-id")
    public Stock viewStockById(int id){
        return stockService.viewStockById(id);
    }
    @DeleteMapping("delete-stock")
    public void deleteStock(int id){
        stockService.removeStock(id);
    }
    @PutMapping("update-stock")
    public Stock updateStock(Stock stock){
        return stockService.updateStock(stock);
    }
}
