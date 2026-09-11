package com.example.virtuallibrary.user.domain.exception;

import com.example.virtuallibrary.shared.domain.exception.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
