package com.example.myproject5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 해당 어노테이션이 선언된 클래스를 상속받는 Entity에 공통 매핑 정보를 제공
@EntityListeners(AuditingEntityListener.class)  // Entity를 DB에 적용하기 전, 커스텀 콜백을 요청
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
//    @Temporal(TemporalType.TIMESTAMP) // LocalDateTime은 @Temporal 생략 가능
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
