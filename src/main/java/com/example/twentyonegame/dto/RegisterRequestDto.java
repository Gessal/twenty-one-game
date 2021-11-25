package com.example.twentyonegame.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequestDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
