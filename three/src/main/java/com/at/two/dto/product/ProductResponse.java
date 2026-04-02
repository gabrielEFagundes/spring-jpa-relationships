package com.at.two.dto.product;

import com.at.two.model.Category;

public record ProductResponse(Long id, String name, double price, Category category) {
}
