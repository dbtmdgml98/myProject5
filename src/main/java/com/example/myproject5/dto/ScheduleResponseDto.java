package com.example.myproject5.dto;

import com.example.myproject5.entity.Schedule;
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

    // toDto를 활용하여 Entity를 Schedule에서 ScheduleResponseDto로 변환하는 메서드
    public static ScheduleResponseDto toDto(Schedule schedule) {

        return new ScheduleResponseDto(schedule.getId(), schedule.getToDoTitle(), schedule.getToDoContents());
    }
}
