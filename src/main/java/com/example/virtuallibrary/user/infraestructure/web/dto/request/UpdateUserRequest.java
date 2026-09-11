package com.example.virtuallibrary.user.infraestructure.web.dto.request;

import com.example.virtuallibrary.user.domain.model.ReaderType;

public record UpdateUserRequest(
        String name,
        String lastname,
        String username,
        ReaderType readerType
) {
}
