package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;
import com.capg.casestudy.onlinemedicalstore.entity.Payment;
public interface PaymentService {
    public Payment addPayment(Payment payments);
    Payment viewPayment(int payment_id);
    List<Payment> viewAllPayment();
}