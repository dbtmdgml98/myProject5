package com.example.myproject5.dto;

import lombok.Getter;

@Getter
public class ScheduleCreateRequestDto {

    private final String toDoTitle;

    private final String toDoContents;

    private final String userName;

    public ScheduleCreateRequestDto(String toDoTitle, String toDoContents, String userName) {
        this.toDoTitle = toDoTitle;
        this.toDoContents = toDoContents;
        this.userName = userName;
    }
}
