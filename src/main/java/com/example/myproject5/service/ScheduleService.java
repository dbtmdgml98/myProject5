package com.example.myproject5.service;

import com.example.myproject5.dto.ScheduleResponseDto;
import com.example.myproject5.entity.Schedule;
import com.example.myproject5.entity.User;
import com.example.myproject5.repository.ScheduleRepository;
import com.example.myproject5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<ScheduleResponseDto> findAll() {

        // 조회된 이 Schedule 리스트를 ScheduleResponseDto 리스트 형태로 반환 받을 수 있게 한다.
       // List<Schedule> findAllSchedule = scheduleRepository.findAll();
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::toDto).toList();
    }

    public ScheduleResponseDto findById(Long id) {

        // Schedule Entity가 아닌 Optional 형태로 반환이 되므로
        // Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        // scheduleRepository 내에서 default로 선언한 메서드를 사용하여 바로 Schedule Entity로 반환받는다! (id를 통해 특정 게시물 조회)
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getToDoTitle(), findSchedule.getToDoContents());
    }
}
