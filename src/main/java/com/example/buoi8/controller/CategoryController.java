package com.example.buoi8.controller;

import com.example.buoi8.entity.Category;
import com.example.buoi8.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category/")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("hienthi")
    public String index(Model model){

        return "index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("cate",new Category());
        return "create";
    }


    @PostMapping("store")
    public String store(Model model, @ModelAttribute("cate") Category cate){
        categoryService.add(cate);
        return "redirect:/category/hienthi";
    }
    @GetMapping("show/{id}")
    public String show(Model model, @PathVariable("id") Category cate){
        model.addAttribute("cate",cate);
        return "show";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") Category cate){
        model.addAttribute("cate",cate);
        return "edit";
    }

    @PostMapping("update/{id}")
    public String update( @ModelAttribute("cate") Category cate){
        categoryService.update(cate);
        return "redirect:/category/hienthi";
    }


    @PostMapping("delete/{id}")
    public String delete( @PathVariable("id") Long id){
        categoryService.delete(id);
        return "redirect:/category/hienthi";
    }
        @GetMapping("search")
    @ResponseBody
    Category searchCategory(@RequestParam("code") String code,
                            @RequestParam("name") String name){
        Category cate = categoryService.searchCategory(code,name);
        return cate;
    }
//
//    @GetMapping("api/hien-thi")
//    @ResponseBody
//    List<Category> getAllApi(){
//        List<Category> list = categoryService.getAll();
//        return list;
//    }

    @GetMapping("api/page-hien-thi")
    @ResponseBody
    List<Category> getAllPageApi(@RequestParam(value = "pageNo",defaultValue = "0") Integer pageNo){
        Integer size = 5;
        return categoryService.getCategory(pageNo,size).getContent();
    }
}
