package com.example.myproject5.dto;

import lombok.Getter;

@Getter
public class ScheduleCreateRequestDto {

    private final Long userId;

    private final String toDoTitle;

    private final String toDoContents;

    public ScheduleCreateRequestDto(Long userId, String toDoTitle, String toDoContents) {
        this.userId = userId;
        this.toDoTitle = toDoTitle;
        this.toDoContents = toDoContents;
    }
}
