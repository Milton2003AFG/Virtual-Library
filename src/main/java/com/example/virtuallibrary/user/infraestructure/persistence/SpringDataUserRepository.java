package com.example.virtuallibrary.user.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, String> {
    boolean existsByUsername(String username);
    Optional<UserJpaEntity> findByUsername(String username);
}
