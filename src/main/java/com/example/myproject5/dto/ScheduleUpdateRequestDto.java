package com.example.myproject5.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleUpdateRequestDto {

    private final String newToDoTitle;

    private final String newToDoContents;

    private final String newUsername;


}
