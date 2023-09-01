package com.capg.casestudy.onlinemedicalstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String cardNo;
    private String expDate;
    private String paymentStatus;
}
