package com.example.myproject5.dto;

import com.example.myproject5.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final Long userId;
    private final String toDoTitle;
    private final String toDoContents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, Long userId, String toDoTitle, String toDoContents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.userId = userId;
        this.toDoTitle = toDoTitle;
        this.toDoContents = toDoContents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    // toDto를 활용하여 Entity를 Schedule에서 ScheduleResponseDto로 변환하는 메서드
    public static ScheduleResponseDto toDto(Schedule schedule) {

        return new ScheduleResponseDto(schedule.getId(), schedule.getUser().getId(), schedule.getToDoTitle(), schedule.getToDoContents(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }
}
