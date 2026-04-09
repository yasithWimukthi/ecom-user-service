package com.microservices.userservice.service;

import com.microservices.userservice.dto.UserRequest;
import com.microservices.userservice.dto.UserResponse;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.mapper.UserMapper;
import com.microservices.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserResponse create(UserRequest request){

        User user = mapper.toEntity(request);

        repository.save(user);

        return mapper.toResponse(user);
    }

}