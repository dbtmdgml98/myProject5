package com.example.myproject5.service;

import com.example.myproject5.dto.ScheduleResponseDto;
import com.example.myproject5.entity.Schedule;
import com.example.myproject5.entity.User;
import com.example.myproject5.repository.ScheduleRepository;
import com.example.myproject5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto save(String toDoTitle, String toDoContents, String username) {

        // 요청 userName을 갖는 유저 조회
        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

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

    @Transactional
    public ScheduleResponseDto update(Long id, String newToDoTitle, String newToToContents, String newUsername) {

        // 요청한 id로 해당 일정 조회
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        // userName을 newUserName으로 수정
        User updateUsername = userRepository.updateByUsernameOrElseThrow(newUsername);

        // 일정에 제목, 내용, 이름 저장
        findSchedule.setToDoTitle(newToDoTitle);
        findSchedule.setToDoContents(newToToContents);
        findSchedule.setUser(updateUsername);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getToDoTitle(), findSchedule.getToDoContents());
    }

    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
