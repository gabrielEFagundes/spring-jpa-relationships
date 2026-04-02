package com.at.two.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ClientRequest(
        @NotBlank(message = "Your name cannot be blank!")
        String name,

        @NotBlank(message = "Your email cannot be blank!")
        @Email(message = "Please, follow the email standarts.")
        String email,

        @NotBlank(message = "Your password shall not be blank!")
        @Min(value = 8, message = "Your password needs at least 8 characters.")
        String password
) {}
