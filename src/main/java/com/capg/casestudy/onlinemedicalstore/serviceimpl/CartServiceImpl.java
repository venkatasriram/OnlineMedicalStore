package com.capg.casestudy.onlinemedicalstore.serviceimpl;

import com.capg.casestudy.onlinemedicalstore.entity.Cart;
import com.capg.casestudy.onlinemedicalstore.entity.Product;
import com.capg.casestudy.onlinemedicalstore.entity.UserDetails;
import com.capg.casestudy.onlinemedicalstore.exception.CartNotFoundException;
import com.capg.casestudy.onlinemedicalstore.repository.CartRepository;
import com.capg.casestudy.onlinemedicalstore.repository.ProductRepository;
import com.capg.casestudy.onlinemedicalstore.repository.UserDetailsRepository;
import com.capg.casestudy.onlinemedicalstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Override
    public Cart addToCart(int productId,int userId) {
        Optional<Cart> cart = cartRepository.findByUserId(userId);
        Optional<Product> product = productRepository.findById(productId);
        if(cart.isEmpty()){
            throw new CartNotFoundException("cart not found");
        }
        if(product.isEmpty()){
            throw new CartNotFoundException("product not found");
        }
        List<Product> products=cart.get().getProducts();
        products.add(product.get());
        cart.get().setProducts(products);
        final double[] totalPrice = {0};
        products.stream().map(Product::getPrice).forEach(price -> totalPrice[0] +=price);
        cart.get().setPrice(totalPrice[0]);
        return cart.get();
    }

    @Override
    public Cart initialCart(UserDetails userDetails) {
        Cart cart = Cart.builder().user(userDetails).products(new ArrayList<>()).price(0).build();
        return cartRepository.save(cart);
    }

    @Override
    public Cart deleteProductFromCart(int userId,int productId){
        Optional<Cart> cart = cartRepository.findByUserId(userId);
        System.out.println("ASDF_DEBUG"+cart.isEmpty()+userId);
        if(cart.isEmpty()){
            throw new CartNotFoundException("cart with user id is not found");
        }
        Optional<Product> cartProduct = cart.get().getProducts().stream().filter(product -> product.getId() == productId).findFirst();
        if (cartProduct.isEmpty()){
            throw new CartNotFoundException("invalid product id");
        }
        cart.get().getProducts().remove(cart.get().getProducts().indexOf(cartProduct.get()));
        return cart.get();
    }

    @Override
    public List<Cart> viewAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Cart viewCartByUserId(int userId) {
        Optional<Cart> cart = cartRepository.findByUserId(userId);
        if(cart.isEmpty()){
            throw new CartNotFoundException("cart with user id is not found");
        }
        return cart.get();
    }
}
