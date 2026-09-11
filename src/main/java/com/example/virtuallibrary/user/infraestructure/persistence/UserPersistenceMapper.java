package com.example.virtuallibrary.user.infraestructure.persistence;

import com.example.virtuallibrary.user.domain.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    UserJpaEntity toEntity(User domain);
    User toDomain(UserJpaEntity entity);
    List<User> toDomainList(List<UserJpaEntity> entityList);
}
