package com.example.twentyonegame.dto;

import com.example.twentyonegame.domain.StatusEntity;
import com.example.twentyonegame.domain.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public UserEntity toUser() {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setStatusEntity(StatusEntity.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(UserEntity user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setFirstName(user.getFirstName());
        adminUserDto.setLastName(user.getLastName());
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setStatus(user.getStatusEntity().name());
        return adminUserDto;
    }
}
