package org.example.ecommerce.domain.interfaces;

import org.example.ecommerce.domain.models.User;

public interface UserRepository {
    User save(User user);
}
