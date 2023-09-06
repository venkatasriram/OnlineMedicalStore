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
    @PostMapping("addPayment/")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }
    @GetMapping("viewPayment/")
    public Payment viewPayment(@RequestParam("paymentId") int id){
        return paymentService.viewPayment(id);
    }
    @DeleteMapping("deletePayment/")
    public void deletePayment(@RequestParam("paymentId") int id){
        paymentService.deletePayment(id);
    }
}
