package org.example.ecommerce.config;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import io.jsonwebtoken.io.Decoders;

@Configuration
public class JwtConfig {
    @Value("${jwt.secretKey}")
    private String secret;

    @Bean
    public JwtDecoder jwtDecoder(){
        byte[] keyBytes = Decoders.BASE64.decode(secret);

        SecretKey key = new SecretKeySpec(
                keyBytes,
                "HmacSHA256"
        );

        return NimbusJwtDecoder
                .withSecretKey(key)
                .macAlgorithm(MacAlgorithm.HS256)
                .build();
    }
}
