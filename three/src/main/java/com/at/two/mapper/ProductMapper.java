package com.at.two.mapper;

import com.at.two.dto.product.ProductRequest;
import com.at.two.dto.product.ProductResponse;
import com.at.two.model.Category;
import com.at.two.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest req, Category category){
        return new Product(req.name(), req.price(), category);
    }

    public ProductResponse toResponse(Product p){
        return new ProductResponse(p.getId(), p.getName(), p.getPrice(), p.getCategory());
    }

    public List<ProductResponse> toResponse(List<Product> p){
        List<ProductResponse> products = new ArrayList<>();

        p.forEach(product -> products.add(toResponse(product)));

        return products;
    }

}
