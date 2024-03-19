package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.dto.AttendanceRecord;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {

    @Mock
    EventService eventService;

    @Mock
    EventRepository eventRepository;

    @Test
    public void getAttendanceByEventIdTest() {

        Optional<Event> eventOptional = this.eventRepository.findById(1L);
        AttendanceResponseDTO expectedData = null;
        if (eventOptional.isPresent()) {
            Event events = eventOptional.get();
            Schedule schedule = events.getSchedule();
            List<Session> sessionList = schedule.getSessions();
            List<AttendanceRecord> attendanceRecord = new ArrayList<>();
            if (!sessionList.isEmpty()) {
                for (Session session : sessionList) {
                    List<Member> memberList = session.getMembers();
                    for (Member member : memberList) {
                        attendanceRecord.add(AttendanceRecord.builder()
                                .memberId(member.getId())
                                .memberFirstName(member.getFirstName())
                                .memberLastName(member.getLastName())
                                .sessionId(session.getId())
                                .sessionDescription(session.getDescription())
                                .sessionName(session.getName())
                                .build());
                    }
                }
            }


            expectedData = AttendanceResponseDTO.builder().count(attendanceRecord.size())
                    .attendanceRecordList(attendanceRecord)
                    .build();

        }

        ResponseEntity<?> eventAttendance = ResponseEntity.ok(this.eventService.getAttendanceForEvent(1L));


        assertEquals(HttpStatus.OK, eventAttendance.getStatusCode());
        assertEquals(expectedData, eventAttendance.getBody());
    }

    @Test
    public void getAllSessionForEventTest(){

    }
}
