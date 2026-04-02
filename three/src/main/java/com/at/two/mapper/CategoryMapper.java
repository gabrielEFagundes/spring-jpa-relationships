package com.at.two.mapper;

import com.at.two.dto.category.CategoryRequest;
import com.at.two.dto.category.CategoryResponse;
import com.at.two.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest req){
        return new Category(req.type());
    }

    public CategoryResponse toResponse(Category c){
        return new CategoryResponse(c.getId(), c.getType(), c.getProducts());
    }

    public List<CategoryResponse> toResponse(List<Category> c){
        List<CategoryResponse> categories = new ArrayList<>();

        c.forEach(category -> categories.add(toResponse(category)));

        return categories;
    }

}
