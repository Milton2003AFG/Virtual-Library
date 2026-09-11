package com.example.virtuallibrary.user.application;

import com.example.virtuallibrary.user.application.dto.UpdateUserCommand;
import com.example.virtuallibrary.user.domain.exception.UserAlreadyExistsException;
import com.example.virtuallibrary.user.domain.exception.UserNotFoundException;
import com.example.virtuallibrary.user.domain.model.User;
import com.example.virtuallibrary.user.domain.port.PasswordEncoderPort;
import com.example.virtuallibrary.user.domain.port.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;

    public UserService(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    public User register(User newUser){
        if (userRepositoryPort.existsByUsername(newUser.getUsername())){
            throw new IllegalArgumentException("The username is already registered");
        }
        String passwordEncypted = passwordEncoderPort.encrypt(newUser.getPassword());

        User userBuild = new User(
                UUID.randomUUID().toString(),
                newUser.getName(),
                newUser.getLastname(),
                newUser.getUsername(),
                passwordEncypted,
                newUser.getReaderType(),
                newUser.getRole());
        return userRepositoryPort.save(userBuild);
    }

    public List<User> listAll(){
        return userRepositoryPort.findAll();
    }

    public User findById(String id){
        return userRepositoryPort.findById(id).orElseThrow(() -> new UserNotFoundException("The user with ID: " + id + " was not found"));
    }

    public User findByUsername(String username){
        return userRepositoryPort.findByUsername(username).orElseThrow(() -> new UserNotFoundException("The user with the username: " + username + " was not found"));
    }

    public void deleteById(String id){
        if (!userRepositoryPort.existsById(id)){
            throw new UserNotFoundException("The user with the ID: " + id + " was not found");
        }
        userRepositoryPort.deleteById(id);
    }

    public User updateUser(String id, UpdateUserCommand command) {
        User existingUser = userRepositoryPort.findById(id).orElseThrow(() -> new UserNotFoundException("The user with the username: " + command.username() + " was not found"));

        if (command.username() != null && !command.username().isBlank() && !command.username().equals(existingUser.getUsername())) {
            if (userRepositoryPort.existsByUsername(command.username())) {
                throw new UserAlreadyExistsException("The username: " + command.username() + " is already in use");
            }
        }
        existingUser.update(
                command.name(),
                command.lastname(),
                command.username(),
                command.readerType()
        );
        return userRepositoryPort.save(existingUser);
    }
}
