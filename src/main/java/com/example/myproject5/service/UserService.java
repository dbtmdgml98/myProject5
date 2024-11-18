package com.example.myproject5.service;

import com.example.myproject5.dto.UserResponseDto;
import com.example.myproject5.dto.UserSignUpResponseDto;
import com.example.myproject5.entity.User;
import com.example.myproject5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSignUpResponseDto signUp(String username, String email, String password) {

        // 요청 값들로 객체 생성 후 DB에 저장
        User user = new User(username, email, password);
        User savedUser = userRepository.save(user);

        return UserSignUpResponseDto.toDto(savedUser);
    }

    public UserResponseDto findById(Long id) {

        // NULL을 안전하게 다루기 위해 Optional 사용
        Optional<User> optionalUser = userRepository.findById(id);

        // 요청한 id 값이 없다면
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exist id : " + id);
        }

        // 요청한 id 값이 있다면
        User findUser = optionalUser.get();

        return UserResponseDto.toDto(findUser);
    }

    public void  delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }

    public User findUserById(Long userId) {
        return userRepository.findByIdOrElseThrow(userId);
    }
}
