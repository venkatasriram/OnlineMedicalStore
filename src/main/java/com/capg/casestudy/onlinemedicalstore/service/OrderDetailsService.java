package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;



import com.capg.casestudy.onlinemedicalstore.entity.OrderDetails;

 

public interface OrderDetailsService {

 

 

    public OrderDetails addOrderDetails(OrderDetails orderDetails);
    public OrderDetails updateOrderDetails(OrderDetails orderDetails);
    public void removeOrderDetails(int id);
    public List<OrderDetails> showAllOrderDetails();
    public OrderDetails showOrdersDetails(int id);
}