package org.example.ecommerce.infrastructure.persistence;

import org.example.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
}
