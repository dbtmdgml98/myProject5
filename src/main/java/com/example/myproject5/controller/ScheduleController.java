package com.example.myproject5.controller;

import com.example.myproject5.dto.ScheduleCreateRequestDto;
import com.example.myproject5.dto.ScheduleResponseDto;
import com.example.myproject5.dto.ScheduleUpdateRequestDto;
import com.example.myproject5.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    // 특정 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    // 특정 일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleUpdateRequestDto requestDto) {

        ScheduleResponseDto updateSchedule = scheduleService.update(id, requestDto.getNewToDoTitle(), requestDto.getNewToDoContents(), requestDto.getNewUserName());

        return new ResponseEntity<>(updateSchedule, HttpStatus.OK);
    }

    // 특정 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
