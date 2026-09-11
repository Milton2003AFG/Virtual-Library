package com.example.virtuallibrary.user.infraestructure.web;

import com.example.virtuallibrary.user.application.UserService;
import com.example.virtuallibrary.user.application.dto.UpdateUserCommand;
import com.example.virtuallibrary.user.domain.model.User;
import com.example.virtuallibrary.user.infraestructure.web.dto.request.RegisterUserRequest;
import com.example.virtuallibrary.user.infraestructure.web.dto.request.UpdateUserRequest;
import com.example.virtuallibrary.user.infraestructure.web.dto.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserWebMapper userWebMapper;

    public UserController(UserService userService, UserWebMapper userWebMapper) {
        this.userService = userService;
        this.userWebMapper = userWebMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody RegisterUserRequest request){
        User userToBuild = new User(
                null, request.name(), request.lastname(),
                request.username(), request.password(), request.readerType(), request.role()
        );

        User userCreated = userService.register(userToBuild);

        UserResponse response = new UserResponse(
                userCreated.getId(),
                userCreated.getName(),
                userCreated.getUsername(),
                userCreated.getReaderType(),
                userCreated.getBooksLimit(),
                userCreated.getRole()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userWebMapper.toResponseList(userService.listAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id){
        User newUser = userService.findById(id);
        return ResponseEntity.ok(userWebMapper.toResponse(newUser));
    }

    @GetMapping(params = "username")
    public ResponseEntity<UserResponse> getUserByUsername(@RequestParam String username) {
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(userWebMapper.toResponse(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest request){
        UpdateUserCommand command = new UpdateUserCommand(
            request.name(), request.lastname(), request.username(), request.readerType()
        );
        User updatedUser = userService.updateUser(id, command);
        return ResponseEntity.ok(userWebMapper.toResponse(updatedUser));
    }
}
