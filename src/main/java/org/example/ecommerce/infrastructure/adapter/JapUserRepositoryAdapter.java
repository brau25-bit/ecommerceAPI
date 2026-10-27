package org.example.ecommerce.infrastructure.adapter;

import org.example.ecommerce.domain.interfaces.UserRepository;
import org.example.ecommerce.domain.models.User;
import org.example.ecommerce.infrastructure.entity.UserEntity;
import org.example.ecommerce.infrastructure.mapper.UserPersistanceMapper;
import org.example.ecommerce.infrastructure.persistence.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JapUserRepositoryAdapter implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    private final UserPersistanceMapper userPersistanceMapper;

    public JapUserRepositoryAdapter(
            JpaUserRepository jpaUserRepository,
            UserPersistanceMapper userPersistanceMapper
    ){
        this.jpaUserRepository = jpaUserRepository;
        this.userPersistanceMapper = userPersistanceMapper;
    }

    @Override
    public User save(User user){
        UserEntity userEntity = this.userPersistanceMapper.toEntity(user);
        UserEntity saved = jpaUserRepository.save(userEntity);

        return this.userPersistanceMapper.toUserModel(saved);
    }

    @Override
    public User findByEmail(String email){
        UserEntity entity = jpaUserRepository.findByEmail(email);

        if(entity == null) return null;

        return this.userPersistanceMapper.toUserModel(entity);
    }

    @Override
    public boolean existsByEmail(String email){
        return jpaUserRepository.existsByEmail(email);
    }
}
