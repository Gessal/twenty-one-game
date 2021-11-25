package com.example.twentyonegame.service.impl;

import com.example.twentyonegame.domain.RoleEntity;
import com.example.twentyonegame.domain.StatusEntity;
import com.example.twentyonegame.domain.UserEntity;
import com.example.twentyonegame.dto.RegisterRequestDto;
import com.example.twentyonegame.dto.UserDto;
import com.example.twentyonegame.repository.RoleRepository;
import com.example.twentyonegame.repository.UserRepository;
import com.example.twentyonegame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис работы с данными пользователей в БД
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //TODO переделать нормально + прикрутить MapStruct для маппинга
    /**
     * Регистрация пользователя.
     * СОхранения данных нового пользователя в БД.
     * @param registerRequestDto
     * @return
     */
    @Override
    public UserDto register(RegisterRequestDto registerRequestDto) {
        RoleEntity roleUser = roleRepository.findByName("ROLE_USER");
        List<RoleEntity> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        UserEntity user = new UserEntity();
        user.setUsername(registerRequestDto.getUsername());
        user.setFirstName(registerRequestDto.getFirstName());
        user.setLastName(registerRequestDto.getLastName());
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        user.setRoleEntities(userRoles);
        user.setStatusEntity(StatusEntity.ACTIVE);

        return entityToDto(userRepository.save(user));
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //TODO костыль пока не прикручу MapStruct
    private UserDto entityToDto(UserEntity entity) {
        UserDto result = new UserDto();
        result.setId(entity.getId());
        result.setUsername(entity.getUsername());
        result.setFirstName(entity.getFirstName());
        result.setLastName(entity.getLastName());
        result.setEmail(entity.getEmail());
        return result;
    }
}
