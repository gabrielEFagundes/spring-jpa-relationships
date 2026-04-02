package com.at.two.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        @NotBlank(message = "The product name cannot be blank!")
        String name,

        @Min(value = 1, message = "The price needs to be at least 1!")
        double price,

        @NotNull(message = "The category ID can't be null.")
        Long categoryId
) {}
