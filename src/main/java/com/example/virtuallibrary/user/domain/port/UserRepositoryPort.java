package com.example.virtuallibrary.user.domain.port;

import com.example.virtuallibrary.user.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    boolean existsByUsername(String username);
    boolean existsById(String id);
    Optional<User> findById(String id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    void deleteById(String id);
}
