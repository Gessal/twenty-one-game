package com.example.twentyonegame.repository;

import com.example.twentyonegame.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String name);
}
