package com.example.twentyonegame.service;

import com.example.twentyonegame.domain.UserEntity;
import com.example.twentyonegame.dto.RegisterRequestDto;
import com.example.twentyonegame.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto register(RegisterRequestDto registerRequestDto);

    UserEntity findByUsername(String username);
}
