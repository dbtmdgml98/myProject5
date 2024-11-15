package com.example.myproject5.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String toDoTitle;

    private final String toDoContents;

    public ScheduleResponseDto(Long id, String toDoTitle, String toDoContents) {
        this.id = id;
        this.toDoTitle = toDoTitle;
        this.toDoContents = toDoContents;
    }
}
