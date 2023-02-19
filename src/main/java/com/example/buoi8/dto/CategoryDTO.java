package com.example.buoi8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
        private  Long id ;
        private String categoryCode;
        private String categoryName;
}