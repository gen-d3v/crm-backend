package com.crmnexus.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(@NotBlank String firstname, String lastname, @NotBlank String username, @NotBlank @Email String email, @NotBlank @Size(min = 8) String rawPassword) {
}
