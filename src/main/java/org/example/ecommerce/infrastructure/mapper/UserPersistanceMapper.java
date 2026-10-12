package org.example.ecommerce.infrastructure.mapper;

import org.example.ecommerce.domain.models.User;
import org.example.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserPersistanceMapper {
    public UserEntity toEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getLastame(),
                user.getAge(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt()
        );
    }

    public User toUserModel(UserEntity user){
        return new User(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getAge(),
                user.getEmail(),
                null,
                user.getCreatedAt()
        );
    }
}
