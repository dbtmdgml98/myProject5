package com.example.myproject5.controller;

import com.example.myproject5.dto.UserSignUpRequestDto;
import com.example.myproject5.dto.UserSignUpResponseDto;
import com.example.myproject5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 저장
    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> signUp(@RequestBody UserSignUpRequestDto requestDto) {

        UserSignUpResponseDto userSignUpResponseDto = userService.signUp(requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(userSignUpResponseDto, HttpStatus.CREATED);
    }
}
