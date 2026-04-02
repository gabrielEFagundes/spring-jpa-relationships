package com.at.two.dto.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
        @NotBlank(message = "The item name cannot be blank!")
        String itemName,

        @Min(value = 1, message = "You need at least one item!")
        Integer amount,

        @NotNull(message = "The client ID can't be null.")
        Long clientId
) {}
