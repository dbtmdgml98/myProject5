package com.example.myproject5.service;

import com.example.myproject5.dto.ScheduleResponseDto;
import com.example.myproject5.entity.Schedule;
import com.example.myproject5.entity.User;
import com.example.myproject5.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    @Transactional
    public ScheduleResponseDto save(Long userId, String toDoTitle, String toDoContents) {

        // 요청 userName을 갖는 유저 조회
        User findUser = userService.findUserById(userId);

        Schedule schedule = new Schedule(findUser, toDoTitle, toDoContents);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return ScheduleResponseDto.toDto(savedSchedule);
    }

    public List<ScheduleResponseDto> findAll() {

        // 조회된 'Schedule 리스트' findAllSchedule를 'ScheduleResponseDto 리스트' 형태로 변환하여 리턴한다.
        List<Schedule> findAllSchedule = scheduleRepository.findAll();
        return findAllSchedule.stream().map(ScheduleResponseDto::toDto).toList();
    }

    public ScheduleResponseDto findById(Long id) {

        // Schedule Entity가 아닌 Optional 형태로 반환이 되므로
        //Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        // scheduleRepository 내에서 default로 선언한 메서드를 사용하여 바로 Schedule Entity로 반환받는다! (id를 통해 특정 게시물 조회)
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return ScheduleResponseDto.toDto(findSchedule);
        // 다른 방법
        //return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getToDoTitle(), findSchedule.getToDoContents(), findSchedule.getCreatedAt(), findSchedule.getModifiedAt());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, String toDoTitle, String toDoContents) {

        // 요청한 id로 해당 일정 조회
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        // 일정에 제목, 내용, 이름 저장
        findSchedule.update(toDoTitle, toDoContents);

        return ScheduleResponseDto.toDto(findSchedule);
    }

    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
