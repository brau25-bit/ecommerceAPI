package org.example.ecommerce.presentation.http.controllers;

import jakarta.validation.Valid;
import org.example.ecommerce.application.UseCase.users.CreateUserCase;
import org.example.ecommerce.application.command.CreateUserCommand;
import org.example.ecommerce.domain.DTO.requests.users.UserRequest;
import org.example.ecommerce.domain.DTO.responses.user.UserResponse;
import org.example.ecommerce.presentation.http.mapper.UserRequestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRequestMapper userRequestMapper;
    private final CreateUserCase createUserCase;

    public UserController(UserRequestMapper userRequestMapper, CreateUserCase createUserCase){
        this.userRequestMapper = userRequestMapper;
        this.createUserCase = createUserCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserRequest userRequest
    ){
        CreateUserCommand user = this.userRequestMapper.toCommand(userRequest);

        UserResponse response = this.createUserCase.execute(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
