package com.example.myproject5.dto;

import com.example.myproject5.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserSignUpResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    public UserSignUpResponseDto(Long id, String username, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    // toDto를 활용하여 Entity를 User에서 UserSignUpResponseDto로 변환하는 메서드
    public static UserSignUpResponseDto toDto(User user) {

        return new UserSignUpResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
}
