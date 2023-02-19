package com.example.buoi8.service.impl;

import com.example.buoi8.dto.CategoryDTO;
import com.example.buoi8.dto.ProductDTO;
import com.example.buoi8.entity.Category;
import com.example.buoi8.entity.Product;
import com.example.buoi8.repository.CategoryRepository;
import com.example.buoi8.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            // mapping
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setCategoryCode(category.getCategoryCode());
            categoryDTO.setCategoryName(category.getCategoryName());

            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public Category searchCategory(String code, String name) {
        return categoryRepository.searchCategoryType1(code,name);
    }

    @Override
    public Category add(Category cate) {
        return categoryRepository.save(cate);
    }


    @Override
    public Category update(Category cate) {
        return categoryRepository.save(cate);
    }

    @Override
    public void delete( Long id) {
         categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> getCategory(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return categoryRepository.findAll(pageable);
    }
}
