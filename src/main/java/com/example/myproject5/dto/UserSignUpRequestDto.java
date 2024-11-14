package com.example.myproject5.dto;

import lombok.Getter;

@Getter
public class UserSignUpRequestDto {

    private final String userName;

    private final String email;

    private final String password;

    public UserSignUpRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
