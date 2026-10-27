package org.example.ecommerce.application.UseCase.users;

import org.example.ecommerce.application.ApplicationMapper.UserApplicationMapper;
import org.example.ecommerce.application.command.CreateUserCommand;
import org.example.ecommerce.domain.DTO.responses.user.UserResponse;
import org.example.ecommerce.presentation.http.errors.EmailAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.example.ecommerce.domain.interfaces.UserRepository;
import org.example.ecommerce.domain.models.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateUserCase {
    private final PasswordEncoder passwordEncoder;
    private final UserApplicationMapper userApplicationMapper;
    private final UserRepository userRepository;

    public CreateUserCase(
            PasswordEncoder passwordEncoder,
            UserApplicationMapper userApplicationMapper,
            UserRepository userRepository
    ){
        this.passwordEncoder = passwordEncoder;
        this.userApplicationMapper = userApplicationMapper;
        this.userRepository = userRepository;
    }

    public UserResponse execute(CreateUserCommand user){
        if(userRepository.existsByEmail(user.email())) {
            throw new EmailAlreadyExistsException("Email is already registered");
        }

        String passwordHashed = this.passwordEncoder.encode(user.password());

        UUID generatedId = UUID.randomUUID();

        User userModel = this.userApplicationMapper.toModelUser(user, passwordHashed, generatedId);

        User userResponse = this.userRepository.save(userModel);

        return this.userApplicationMapper.toUserResponse(userResponse);
    }
}
