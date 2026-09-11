package com.example.virtuallibrary.user.application.dto;

import com.example.virtuallibrary.user.domain.model.ReaderType;

public record UpdateUserCommand(
        String name,
        String lastname,
        String username,
        ReaderType readerType
) {
}
