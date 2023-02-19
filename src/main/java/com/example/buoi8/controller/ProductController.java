package com.example.buoi8.controller;

import com.example.buoi8.dto.CategoryDTO;
import com.example.buoi8.dto.ProductDTO;
import com.example.buoi8.entity.Category;
import com.example.buoi8.service.CategoryService;
import com.example.buoi8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/product/hienthi")
    public String index(Model model,@RequestParam(value = "page",defaultValue = "0") String pageNumber){

        List<CategoryDTO> listc = categoryService.getAll();
        model.addAttribute("categories",listc);
        model.addAttribute("p",new ProductDTO());
        int limit = 1;
        Integer page = pageNumber == null ? 0 : Integer.parseInt(pageNumber);
        model.addAttribute("pageData", productService.getProduct(page,limit));
        return "index";
    }

    @PostMapping("/product/store")
    public String store(Model model, @ModelAttribute("p") ProductDTO productDTO){
        productService.add(productDTO);
        return "redirect:/product/hienthi";
    }
    @GetMapping("/product/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        ProductDTO productDTO = productService.getById(Long.valueOf(id));
        model.addAttribute("p",productDTO);
        List<CategoryDTO> listc = categoryService.getAll();
        model.addAttribute("categories",listc);
        return "edit";
    }

    @PostMapping("/product/update/{id}")
    public String update( @ModelAttribute("p") ProductDTO productDTO){
        productService.update(productDTO);
        return "redirect:/product/hienthi";
    }

    @GetMapping("/product/delete/{id}")
    public String delete( @PathVariable("id") Long id){
        productService.delete(id);
        return "redirect:/product/hienthi";
    }
}
