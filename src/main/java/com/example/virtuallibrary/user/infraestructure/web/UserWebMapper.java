package com.example.virtuallibrary.user.infraestructure.web;

import com.example.virtuallibrary.user.domain.model.User;
import com.example.virtuallibrary.user.infraestructure.web.dto.response.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserWebMapper {
    UserResponse toResponse(User user);
    List<UserResponse> toResponseList(List<User> users);
}
