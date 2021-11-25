package com.example.twentyonegame.service;

import com.example.twentyonegame.domain.UserEntity;
import com.example.twentyonegame.dto.User;
import com.example.twentyonegame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<SimpleGrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority("user"));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
