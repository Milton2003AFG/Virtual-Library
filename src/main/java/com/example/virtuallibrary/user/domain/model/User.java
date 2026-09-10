package com.example.virtuallibrary.user.domain.model;

import com.example.virtuallibrary.shared.annotation.Default;

import java.time.LocalDate;

public class User {
    private final String id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private final LocalDate registrationDate;
    private ReaderType readerType;
    private Role role;

    public User(String id, String name, String lastname, String username, String password, ReaderType readerType, Role role){
        this(id, name, lastname, username, password, LocalDate.now(), readerType, role);
    }

    @Default
    public User(String id, String name, String lastname, String username, String password, LocalDate registrationDate, ReaderType readerType, Role role){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
        this.readerType = readerType;
        this.role = role;
    }


    public int getBooksLimit(){
        return this.readerType.getBooksLimit();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public Role getRole() {
        return role;
    }

    public void update(String name, String lastname, String username, ReaderType readerType){
        if (name != null && !name.isBlank()){
            this.name = name.trim();
        }
        if (lastname != null && !lastname.isBlank()){
            this.lastname = lastname.trim();
        }
        if (username != null && !username.isBlank()){
            this.username = username.trim();
        }
        if (readerType != null){
            this.readerType = readerType;
        }
    }
}
