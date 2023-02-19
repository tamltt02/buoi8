package com.example.buoi8.service.impl;

import com.example.buoi8.dto.CategoryDTO;
import com.example.buoi8.dto.ProductDTO;
import com.example.buoi8.entity.Category;
import com.example.buoi8.entity.Product;
import com.example.buoi8.repository.CategoryRepository;
import com.example.buoi8.repository.ProductRepository;
import com.example.buoi8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    List<ProductDTO> productDTOs = new ArrayList<>();

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = repository.findAll();
        for (Product p : products) {
            // mapping
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(p.getId());
            productDTO.setProductName(p.getProductName());
            productDTO.setProductCode(p.getProductCode());
            productDTO.setCategory(p.getCategory());
            productDTO.setPrice(p.getPrice());
            productDTO.setDescription(p.getDescription());
            productDTOs.add(productDTO);
        }
        return productDTOs;

    }
    public ProductDTO getById(Long id) {
        Product p = repository.getById(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(p.getId());
        productDTO.setProductName(p.getProductName());
        productDTO.setProductCode(p.getProductCode());
        productDTO.setCategory(p.getCategory());
        productDTO.setPrice(p.getPrice());
        productDTO.setDescription(p.getDescription());
        return productDTO;
    }



    @Override
    public Product add(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(0);
        product.setProductName(productDTO.getProductName());
        product.setProductCode(productDTO.getProductCode());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        return repository.save(product);

    }

    @Override
    public Product update(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setProductCode(productDTO.getProductCode());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Product> getProduct(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return repository.findAll(pageable);
    }
}
