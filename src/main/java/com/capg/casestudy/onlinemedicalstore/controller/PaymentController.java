package com.capg.casestudy.onlinemedicalstore.controller;

import com.capg.casestudy.onlinemedicalstore.entity.Payment;
import com.capg.casestudy.onlinemedicalstore.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/payment/")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("add-payment/")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }
    @GetMapping("view-payment/")
    public Payment viewPayment(@RequestParam("paymentId") int id){
        return paymentService.viewPayment(id);
    }
    @DeleteMapping("delete-payment/")
    public void deletePayment(@RequestParam("paymentId") int id){
        paymentService.deletePayment(id);
    }
}
