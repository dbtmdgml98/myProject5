package com.example.myproject5.service;

import com.example.myproject5.dto.UserSignUpResponseDto;
import com.example.myproject5.entity.User;
import com.example.myproject5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSignUpResponseDto signUp(String userName, String email, String password) {

        User user = new User(userName, email, password);
        User savedUser = userRepository.save(user);

        return new UserSignUpResponseDto(savedUser.getId(), savedUser.getUserName(), savedUser.getEmail());
    }

}
