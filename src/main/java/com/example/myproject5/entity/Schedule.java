package com.example.myproject5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String toDoTitle;

    @Column(columnDefinition = "longtext")
    private String toDoContents;

    // 연관 관계 설정
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 기본 생성자
    public Schedule() {}

    // 생성자 (자동생성되는 id와 참조하는 user는 제외)
    public Schedule(String toDoTitle, String toDoContents) {
        this.toDoTitle = toDoTitle;
        this.toDoContents = toDoContents;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void update(String toDoTitle, String toDoContents) {
        this.toDoTitle = toDoTitle;
        this.toDoContents = toDoContents;
    }
}
