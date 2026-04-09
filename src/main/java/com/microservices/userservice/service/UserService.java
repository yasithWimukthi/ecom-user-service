package com.microservices.userservice.service;

import com.microservices.userservice.dto.UserRequest;
import com.microservices.userservice.dto.UserResponse;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.mapper.UserMapper;
import com.microservices.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserResponse create(UserRequest request){

        log.info("Creating user with email {}", request.getEmail());

        User user = mapper.toEntity(request);

        repository.save(user);

        log.info("User created with id {}", user.getId());

        return mapper.toResponse(user);
    }

}