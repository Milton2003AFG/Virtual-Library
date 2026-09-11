package com.example.virtuallibrary.user.infraestructure.persistence;

import com.example.virtuallibrary.user.domain.model.ReaderType;
import com.example.virtuallibrary.user.domain.model.Role;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserJpaEntity {
    @Id
    private String id;
    private String name;
    private String lastname;

    @Column(unique = true)
    private String username;
    private String password;
    private LocalDate registerDate;

    @Enumerated(EnumType.STRING)
    private ReaderType readerType;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserJpaEntity(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
