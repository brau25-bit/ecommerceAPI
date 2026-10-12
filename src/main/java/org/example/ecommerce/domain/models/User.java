package org.example.ecommerce.domain.models;

import java.time.Instant;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final String lastName;
    private final Integer age;
    private final String email;
    private final String password;
    private final Instant createdAt;

    public User(
            UUID id,
            String name,
            String lastName,
            Integer age,
            String email,
            String password,
            Instant createdAt
    ){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public UUID getId(){ return this.id; }

    public String getName(){
        return this.name;
    }

    public String getLastame(){
        return this.lastName;
    }

    public int getAge(){
        return this.age;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public Instant getCreatedAt(){ return this.createdAt; }
}
