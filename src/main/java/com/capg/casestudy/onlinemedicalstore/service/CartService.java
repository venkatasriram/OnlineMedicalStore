package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;



import com.capg.casestudy.onlinemedicalstore.entity.Cart;
import com.capg.casestudy.onlinemedicalstore.entity.UserDetails;


public interface CartService {
    Cart addToCart(int productId,int userId);
    Cart initialCart(UserDetails userDetails);
    Cart deleteProductFromCart(int userId,int productId);
    List<Cart> viewAllCart();
    Cart viewCartByUserId(int userId);
}