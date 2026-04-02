package com.at.two.controller;

import com.at.two.dto.product.ProductRequest;
import com.at.two.dto.product.ProductResponse;
import com.at.two.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest req){
        return service.add(req);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping(params = "name")
    public List<ProductResponse> getByProductName(@RequestParam("name") String name){
        return service.getByName(name);
    }

    @GetMapping(params = "category")
    public List<ProductResponse> getByCategoryName(@RequestParam("category") String category){
        return service.getByCategoryName(category);
    }

}
