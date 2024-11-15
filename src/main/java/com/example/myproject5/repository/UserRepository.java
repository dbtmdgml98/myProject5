package com.example.myproject5.repository;

import com.example.myproject5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Optional
    Optional<User> findUserByUserName(String userName);

    // default를 사용하여 인터페이스에 메서드 구현 (Optional이 아닌 User Entity로  반환된다!)
    default User findUserByUserNameOrElseThrow(String userName) {

        return findUserByUserName(userName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exist userName : " + userName));
    }

    default User findByIdOrElseThrow(Long id) {

        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exist id : " + id));
    }
}