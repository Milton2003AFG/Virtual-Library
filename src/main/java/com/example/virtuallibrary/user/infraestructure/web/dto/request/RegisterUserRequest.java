package com.example.virtuallibrary.user.infraestructure.web.dto.request;

import com.example.virtuallibrary.user.domain.model.ReaderType;
import com.example.virtuallibrary.user.domain.model.Role;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserRequest(
        @NotBlank(message = "The name is mandatory")
        String name,
        @NotBlank(message = "The lastname is mandatory")
        String lastname,
        @NotBlank(message = "The username is mandatory")
        String username,
        @NotBlank(message = "The password is mandatory")
        String password,

        ReaderType readerType,
        Role role
) {
}
