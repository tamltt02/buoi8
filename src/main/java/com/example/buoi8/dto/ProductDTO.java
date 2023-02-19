package com.example.buoi8.dto;

import com.example.buoi8.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private Category category;
    private String productCode;
    private String productName;
    private double price;
    private String description;

}
