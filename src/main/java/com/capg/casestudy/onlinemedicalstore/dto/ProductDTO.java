package com.capg.casestudy.onlinemedicalstore.dto;

import com.capg.casestudy.onlinemedicalstore.entity.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String productName;
    private String description;
    private String expDate;
    private String mfgDate;
    private Double price;
    private int supplierId;

}
