package org.example.ecommerce.domain.models;

public class User {
    private String name;
    private String lastName;
    private Integer age;
    private String email;
    private String password;

    public User(
            String name,
            String lastName,
            Integer age,
            String email,
            String password
    ){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

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
}
