package org.example.ecommerce.application.UseCase.users;

import org.example.ecommerce.domain.DTO.responses.user.LoginResponse;
import org.example.ecommerce.domain.interfaces.UserRepository;
import org.example.ecommerce.domain.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class GetUserCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public GetUserCase(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse execute(String email, String password){

        User response = this.userRepository.findByEmail(email);

        return new LoginResponse(
                "Hola",
                Instant.now(),
                Instant.now()
        );
    }
}
