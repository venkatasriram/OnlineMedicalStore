package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;
import com.capg.casestudy.onlinemedicalstore.entity.Payment;
public interface PaymentService {
    public Payment addPayment(Payment payment);
    public Payment viewPayment(int id);
    public void deletePayment(int id);
}