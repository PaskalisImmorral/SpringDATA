package com.example.introtospringdata.service;

import com.example.introtospringdata.models.Account;
import com.example.introtospringdata.models.User;
import com.example.introtospringdata.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username , int age) {
        if(username.isBlank() || age < 18){
            throw new RuntimeException("Validation failed");
        }
         Optional<User> findUser =  userRepository.findByUsername(username);
        if (findUser.isPresent()){
            throw new RuntimeException("User is already exist");
        }

        Account account = new Account();
        User user = new User(username,age, account);
        this.userRepository.save(user);
    }
}
