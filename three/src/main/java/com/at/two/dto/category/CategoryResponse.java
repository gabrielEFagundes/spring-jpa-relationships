package com.at.two.dto.category;

import com.at.two.model.Product;

import java.util.List;

public record CategoryResponse(Long id, String type, List<Product> products) {
}
