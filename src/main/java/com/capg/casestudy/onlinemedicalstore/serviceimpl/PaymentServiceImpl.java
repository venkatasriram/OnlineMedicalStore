package com.capg.casestudy.onlinemedicalstore.serviceimpl;

import com.capg.casestudy.onlinemedicalstore.entity.Payment;
import com.capg.casestudy.onlinemedicalstore.exception.PaymentNotFoundException;
import com.capg.casestudy.onlinemedicalstore.repository.PaymentRepository;
import com.capg.casestudy.onlinemedicalstore.service.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment viewPayment(int id) {
        Optional<Payment> payment=paymentRepository.findById(id);
        if (payment.isEmpty()){
            throw new PaymentNotFoundException("payment not found");
        }
        return payment.get();
    }

    @Override
    public void deletePayment(int id) {
        Optional<Payment> payment=paymentRepository.findById(id);
        if (payment.isEmpty()){
            throw new PaymentNotFoundException("payment not found");
        }
        paymentRepository.delete(payment.get());
    }
}
