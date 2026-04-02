package com.at.two.controller;

import com.at.two.dto.category.CategoryRequest;
import com.at.two.dto.category.CategoryResponse;
import com.at.two.model.Product;
import com.at.two.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public CategoryResponse addCategory(@RequestBody CategoryRequest req){
        return service.add(req);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategory(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable("id") Long id){
        return service.getById(id);
    }

}
