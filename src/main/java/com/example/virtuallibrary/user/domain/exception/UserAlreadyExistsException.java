package com.example.virtuallibrary.user.domain.exception;

import com.example.virtuallibrary.shared.domain.exception.ResourceAlreadyExistsException;

public class UserAlreadyExistsException extends ResourceAlreadyExistsException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
