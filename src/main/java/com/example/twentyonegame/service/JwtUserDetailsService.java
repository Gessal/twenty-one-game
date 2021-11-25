package com.example.twentyonegame.service;

import com.example.twentyonegame.domain.UserEntity;
import com.example.twentyonegame.dto.JwtUserDto;

import com.example.twentyonegame.repository.UserRepository;
import com.example.twentyonegame.util.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Сервис получения данных о пользователе из БД
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public JwtUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        return JwtUserFactory.create(user);
    }
}
