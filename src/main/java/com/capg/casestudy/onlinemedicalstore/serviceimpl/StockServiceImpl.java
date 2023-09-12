package com.capg.casestudy.onlinemedicalstore.serviceimpl;

import com.capg.casestudy.onlinemedicalstore.entity.Product;
import com.capg.casestudy.onlinemedicalstore.entity.Stock;
import com.capg.casestudy.onlinemedicalstore.exception.StockNotFoundException;
import com.capg.casestudy.onlinemedicalstore.repository.ProductRepository;
import com.capg.casestudy.onlinemedicalstore.repository.StockRepository;
import com.capg.casestudy.onlinemedicalstore.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@Transactional
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Stock addStock(int productId,int quantity) {
        Optional<Stock> stock = stockRepository.findByProductId(productId);
        if(stock.isEmpty()){
            throw new StockNotFoundException("invalid product id");
        }
        int totalQuantity=quantity+stock.get().getQuantity();
        stock.get().setQuantity(totalQuantity);
        stock.get().setIsInStock(totalQuantity>0);
        return stock.get();
    }
    @Override
    public Stock initialStockForProduct(Product product) {
        Stock stock = Stock.builder().isInStock(false).quantity(0).product(product).build();
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        Optional<Stock> stockDetails = stockRepository.findById(stock.getId());
        if(stockDetails.isEmpty()){
            throw new StockNotFoundException("stock not found");
        }
        if(!Objects.equals(stock.getQuantity(),stockDetails.get().getQuantity())){
            stockDetails.get().setQuantity(stock.getQuantity());
        }
        stockDetails.get().setIsInStock(stock.getQuantity()>0);
        return stockDetails.get();
    }

    @Override
    public void removeStock(int id) {
        Optional<Stock> stockDetails = stockRepository.findById(id);
        if(stockDetails.isEmpty()){
            throw new StockNotFoundException("stock not found");
        }
        stockRepository.delete(stockDetails.get());
    }

    @Override
    public List<Stock> viewAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock viewStockById(int id) {
        Optional<Stock> stockDetails = stockRepository.findById(id);
        if(stockDetails.isEmpty()){
            throw new StockNotFoundException("stock not found");
        }
        return stockDetails.get();
    }
}
