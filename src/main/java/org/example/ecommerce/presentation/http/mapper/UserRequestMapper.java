package org.example.ecommerce.presentation.http.mapper;

import org.example.ecommerce.application.command.CreateUserCommand;
import org.example.ecommerce.domain.DTO.requests.users.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper {
    public CreateUserCommand toCommand(UserRequest request){
        return new CreateUserCommand(
                request.name(),
                request.lastName(),
                request.age(),
                request.email(),
                request.password()
        );
    }
}
