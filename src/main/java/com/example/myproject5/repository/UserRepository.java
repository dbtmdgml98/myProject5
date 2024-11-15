package com.example.myproject5.repository;

import com.example.myproject5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Optional
    Optional<User> findUserByUsername(String username);
    // default를 사용하여 인터페이스에 메서드 구현 (Optional이 아닌 User Entity로  반환된다!)
    default User findUserByUsernameOrElseThrow(String username) {
        return findUserByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exist username : " + username));
    }

    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exist id : " + id));
    }

    Optional<User> findByUsername(String newUsername);
    default User findByUsernameOrElseThrow(String newUsername) {
        return findByUsername(newUsername).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exist newUsername : " + newUsername));
    }
}