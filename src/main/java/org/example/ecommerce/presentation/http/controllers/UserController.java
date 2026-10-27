package org.example.ecommerce.presentation.http.controllers;

import jakarta.validation.Valid;
import org.example.ecommerce.application.UseCase.users.CreateUserCase;
import org.example.ecommerce.application.UseCase.users.userLoginCase;
import org.example.ecommerce.application.command.CreateUserCommand;
import org.example.ecommerce.domain.DTO.requests.users.LoginRequest;
import org.example.ecommerce.domain.DTO.requests.users.UserRequest;
import org.example.ecommerce.domain.DTO.responses.user.LoginResponse;
import org.example.ecommerce.domain.DTO.responses.user.UserResponse;
import org.example.ecommerce.presentation.http.mapper.UserRequestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserRequestMapper userRequestMapper;
    private final CreateUserCase createUserCase;
    private final userLoginCase userLoginCase;

    public UserController(
            UserRequestMapper userRequestMapper,
            CreateUserCase createUserCase,
            userLoginCase userLoginCase
    ){
        this.userRequestMapper = userRequestMapper;
        this.createUserCase = createUserCase;
        this.userLoginCase = userLoginCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserRequest userRequest
    ){
        CreateUserCommand user = this.userRequestMapper.toCommand(userRequest);

        UserResponse response = this.createUserCase.execute(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> getUser(
            @Valid @RequestBody LoginRequest request
    ){
        LoginResponse response = this.userLoginCase.execute(request.email(), request.password());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
