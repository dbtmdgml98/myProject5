package com.example.myproject5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 기능을 활성화
@SpringBootApplication
public class MyProject5Application {

    public static void main(String[] args) {
        SpringApplication.run(MyProject5Application.class, args);
    }

}
