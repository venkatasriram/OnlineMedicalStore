package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;



import com.capg.casestudy.onlinemedicalstore.entity.Cart;

 

public interface CartService {
    public Cart addCart(Cart cart);
    public Cart updateCart(Cart cart);
    public void removeCart(int id);
    public List<Cart> showAllCarts();
    public Cart showCart(int id);
}