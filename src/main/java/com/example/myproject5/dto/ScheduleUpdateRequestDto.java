package com.example.myproject5.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private final String toDoTitle;

    private final String toDoContents;


    public ScheduleUpdateRequestDto(String toDoTitle, String toDoContents) {
        this.toDoTitle = toDoTitle;
        this.toDoContents = toDoContents;
    }
}
