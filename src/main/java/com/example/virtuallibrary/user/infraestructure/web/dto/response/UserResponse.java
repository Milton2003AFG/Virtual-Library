package com.example.virtuallibrary.user.infraestructure.web.dto.response;

import com.example.virtuallibrary.user.domain.model.ReaderType;
import com.example.virtuallibrary.user.domain.model.Role;

public record UserResponse(
        String id,
        String name,
        String username,
        ReaderType readerType,
        int booksLimit,
        Role role
) {
}
