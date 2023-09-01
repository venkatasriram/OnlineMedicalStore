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
public class UserDetails {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String userName;
    private String password;
    private String role;
    private String mobile;
    private String address;
}