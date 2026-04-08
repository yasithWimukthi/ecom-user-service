package com.microservices.userservice.service;

import com.microservices.userservice.entity.User;
import com.microservices.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User create(User user){
        user.setCreatedAt(LocalDateTime.now());
        return repository.save(user);
    }

}