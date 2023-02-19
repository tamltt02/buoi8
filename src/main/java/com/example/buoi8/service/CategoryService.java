package com.example.buoi8.service;

import com.example.buoi8.dto.CategoryDTO;
import com.example.buoi8.entity.Category;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();

    Category searchCategory(String code, String name);

    Category add(Category cate);
    Category update(Category cate);
    void delete(Long id);

    Page<Category> getCategory(Integer pageNo, Integer size);
}
