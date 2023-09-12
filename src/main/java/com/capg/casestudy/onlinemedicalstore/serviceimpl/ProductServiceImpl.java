package com.capg.casestudy.onlinemedicalstore.serviceimpl;

import com.capg.casestudy.onlinemedicalstore.dto.ProductDTO;
import com.capg.casestudy.onlinemedicalstore.entity.Product;
import com.capg.casestudy.onlinemedicalstore.entity.Supplier;
import com.capg.casestudy.onlinemedicalstore.exception.PaymentNotFoundException;
import com.capg.casestudy.onlinemedicalstore.exception.ProductNotFoundException;
import com.capg.casestudy.onlinemedicalstore.repository.ProductRepository;
import com.capg.casestudy.onlinemedicalstore.repository.SupplierRepository;
import com.capg.casestudy.onlinemedicalstore.service.ProductService;
import com.capg.casestudy.onlinemedicalstore.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private StockService stockService;

    @Override
    public Product addProduct(ProductDTO productDTO) {
        Optional<Supplier> supplier = supplierRepository.findById(productDTO.getSupplierId());
        if(supplier.isEmpty()){
            throw new ProductNotFoundException("can't add product with out supplier");
        }
        Product product=new Product();
        product.setSupplier(supplier.get());
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setMfgDate(productDTO.getMfgDate());
        product.setExpDate(productDTO.getExpDate());
        product.setPrice(productDTO.getPrice());
        Product savedProduct = productRepository.save(product);
        stockService.initialStockForProduct(savedProduct);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDetails=productRepository.findById(product.getId());
        if(productDetails.isEmpty()){
            throw new PaymentNotFoundException("product not found");
        }
        if(product.getProductName()!=null && product.getProductName().length()>0 && !Objects.equals(productDetails.get().getProductName(),product.getProductName())){
            productDetails.get().setProductName(product.getProductName());
        }
        if(product.getDescription()!=null && product.getDescription().length()>0 && !Objects.equals(productDetails.get().getDescription(),product.getDescription())){
            productDetails.get().setDescription(product.getDescription());
        }
        if(product.getPrice()!=0 && !Objects.equals(productDetails.get().getPrice(),product.getPrice())){
            productDetails.get().setPrice(product.getPrice());
        }
        if(product.getMfgDate()!=null && product.getMfgDate().length()>0 && !Objects.equals(productDetails.get().getMfgDate(),product.getMfgDate())){
            productDetails.get().setMfgDate(product.getMfgDate());
        }
        if(product.getExpDate()!=null && product.getExpDate().length()>0 && !Objects.equals(productDetails.get().getExpDate(),product.getExpDate())){
            productDetails.get().setExpDate(product.getExpDate());
        }
        return productDetails.get();
    }

    @Override
    public void removeProduct(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ProductNotFoundException("product not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> viewAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product viewProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ProductNotFoundException("product not found");
        }
        return product.get();
    }
}
