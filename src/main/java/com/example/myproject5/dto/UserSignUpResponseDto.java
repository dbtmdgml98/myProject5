package com.example.myproject5.dto;

import lombok.Getter;

@Getter
public class UserSignUpResponseDto {

    private final Long id;

    private final String userName;

    private final String email;

    public UserSignUpResponseDto(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
