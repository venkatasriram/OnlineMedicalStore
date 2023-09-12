package com.capg.casestudy.onlinemedicalstore.controller;

import com.capg.casestudy.onlinemedicalstore.entity.Cart;
import com.capg.casestudy.onlinemedicalstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cart/")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("add-to-cart")
    public Cart addToCart(int userId,int productId){
        return cartService.addToCart(userId,productId);
    }
    @GetMapping("view-all-carts")
    public List<Cart> viewAllCart(){
        return cartService.viewAllCart();
    }
    @GetMapping("view-cart-by-user-id")
    public Cart viewCartByUserId(int id){
        return cartService.viewCartByUserId(id);
    }
    @DeleteMapping("delete-product-from-cart")
    public Cart deleteProductFromCart(int userId,int productId){
        return cartService.deleteProductFromCart(userId,productId);
    }
}
