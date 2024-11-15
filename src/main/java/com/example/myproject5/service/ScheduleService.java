package com.example.myproject5.service;

import com.example.myproject5.dto.ScheduleResponseDto;
import com.example.myproject5.entity.Schedule;
import com.example.myproject5.entity.User;
import com.example.myproject5.repository.ScheduleRepository;
import com.example.myproject5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto save(String toDoTitle, String toDoContents, String userName) {

        // 요청 userName을 갖는 유저 조회
        User findUser = userRepository.findUserByUserNameOrElseThrow(userName);

        Schedule schedule = new Schedule(toDoTitle, toDoContents);

        // Schedule에 요청 정보 저장
        schedule.setUser(findUser);
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getToDoTitle(), savedSchedule.getToDoContents());
    }
}
