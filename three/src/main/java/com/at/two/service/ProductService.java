package com.at.two.service;

import com.at.two.dto.product.ProductRequest;
import com.at.two.dto.product.ProductResponse;
import com.at.two.mapper.ProductMapper;
import com.at.two.model.Category;
import com.at.two.repository.CategoryRepository;
import com.at.two.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper mapper;

    public ProductResponse add(ProductRequest req){
        if(!categoryRepository.existsById(req.categoryId())){
            throw new RuntimeException("Ops! Category does not exists!");
        }

        Category category = categoryRepository.findById(req.categoryId()).orElseThrow(() -> new RuntimeException("Nope (Category By Id)"));

        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req, category)
                )
        );
    }

    public List<ProductResponse> getAll(){
        return mapper.toResponse(repository.findAll());
    }

    // can be a list since more than one product can have the same name...!
    public List<ProductResponse> getByName(String name){
        return mapper.toResponse(repository.findAllByName(name));
    }

    public ProductResponse getById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (Product by Id)")));
    }

    // also can be a list duh
    public List<ProductResponse> getByCategoryName(String categoryName){
        return mapper.toResponse(repository.findAllByCategoryType(categoryName));
    }

}
