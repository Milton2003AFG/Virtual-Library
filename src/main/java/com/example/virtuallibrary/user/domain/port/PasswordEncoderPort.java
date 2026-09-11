package com.example.virtuallibrary.user.domain.port;

public interface PasswordEncoderPort {
    String encrypt(String rawPassword);
    boolean match(String rawPassword, String encodedPassword);
}
