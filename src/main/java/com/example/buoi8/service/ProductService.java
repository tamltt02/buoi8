package com.example.buoi8.service;

import com.example.buoi8.dto.ProductDTO;
import com.example.buoi8.entity.Category;
import com.example.buoi8.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductService  {

    List<ProductDTO> getAll();
    Product add(ProductDTO product);
    Product update(ProductDTO product);
    void delete(Long id);
    Page<Product> getProduct(Integer pageNo, Integer size);
    ProductDTO getById(Long id);
}
