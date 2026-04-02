package com.at.two.dto.category;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank(message = "The category shall not be blank!")
        String type
) {}
