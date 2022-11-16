package com.example.introtospringdata.service;

import com.example.introtospringdata.models.User;

import java.util.Optional;

public interface UserService {
    void registerUser(String username, int age);
}
