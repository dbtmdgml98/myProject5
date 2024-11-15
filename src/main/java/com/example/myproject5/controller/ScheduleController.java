package com.example.myproject5.controller;

import com.example.myproject5.dto.ScheduleCreateRequestDto;
import com.example.myproject5.dto.ScheduleResponseDto;
import com.example.myproject5.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 저장
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleCreateRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getToDoTitle(), requestDto.getToDoContents(), requestDto.getUserName());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }
}
