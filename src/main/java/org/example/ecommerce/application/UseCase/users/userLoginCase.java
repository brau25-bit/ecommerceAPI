package org.example.ecommerce.application.UseCase.users;

import org.example.ecommerce.domain.DTO.responses.user.LoginResponse;
import org.example.ecommerce.domain.interfaces.UserRepository;
import org.example.ecommerce.domain.models.User;
import org.example.ecommerce.domain.ports.JwtPort;
import org.example.ecommerce.presentation.http.errors.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.desktop.SystemSleepEvent;
import java.time.Instant;
import java.util.Date;

@Service
public class userLoginCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtPort jwtPort;

    @Value("${jwt.expiration}")
    private long expiration;

    public userLoginCase(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtPort jwtPort
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtPort = jwtPort;
    }

    public LoginResponse execute(String email, String password){
        User response = this.userRepository.findByEmail(email);

        if(!this.passwordEncoder.matches(password, response.getPassword())) throw new BadRequestException("Field is wrong");

        String token = this.jwtPort.generateJwt(response.getEmail());

        return new LoginResponse(
                token,
                new Date(System.currentTimeMillis() + expiration)
        );
    }
}
