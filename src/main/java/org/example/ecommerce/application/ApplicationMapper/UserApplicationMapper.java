package org.example.ecommerce.application.ApplicationMapper;

import org.example.ecommerce.application.command.CreateUserCommand;
import org.example.ecommerce.domain.DTO.responses.user.UserResponse;
import org.example.ecommerce.domain.models.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class UserApplicationMapper {

    public User toModelUser(CreateUserCommand user, String password, UUID id){
        return new User(
                id,
                user.name(),
                user.lastName(),
                user.age(),
                user.email(),
                password,
                Instant.now()
        );
    }

    public UserResponse toUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getLastame(),
                user.getAge(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}
