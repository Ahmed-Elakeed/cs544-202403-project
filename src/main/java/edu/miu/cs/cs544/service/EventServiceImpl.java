package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.dto.AttendanceRecord;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.exception.InvalidCredentialsException;
import edu.miu.cs.cs544.exception.NotFoundException;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.contract.AttendanceDTO;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import edu.miu.cs.cs544.service.mapper.SessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl extends BaseReadWriteServiceImpl<EventPayload, Event, Long> implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<SessionPayload> getAllSessionsForEvent(Long eventId) {
        Optional<Event> eventOptional = this.eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            return event.getSchedule().getSessions()
                    .stream()
                    .map(SessionMapper::toSessionPayload)
                    .toList();
        }
        throw new NotFoundException("Event not exist");
    }

    @Override
    public SessionPayload getSessionForEvent(Long eventId, Long sessionId) {
        Optional<Event> eventOptional = this.eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Optional<Session> sessionOptional = eventOptional.get()
                    .getSchedule().getSessions()
                    .stream()
                    .filter(session -> session.getId().equals(sessionId))
                    .findFirst();
            if (sessionOptional.isPresent()) {
                Session session = sessionOptional.get();
                return new SessionPayload(
                        session.getId(),
                        session.getName(),
                        session.getDescription(),
                        session.getStartDateTime(),
                        session.getEndDateTime()
                );
            }
        }
        throw new NotFoundException("Event or session not exist");
    }

    @Override
    public SessionPayload saveSessionForEvent(Long eventId, SessionPayload sessionPayload) {
        Optional<Event> eventOptional = this.eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            if (!this.convertDateToLocalDate(sessionPayload.getStartDateTime()).isBefore(event.getStartDateTime())
                    && !this.convertDateToLocalDate(sessionPayload.getEndDateTime()).isAfter(event.getEndDateTime())) {
                event.getSchedule().getSessions().add(SessionMapper.toSession(sessionPayload));
                this.eventRepository.save(event);
                return sessionPayload;
            }else{
                throw new InvalidCredentialsException("Session date has to be in the event range");
            }
        }
        throw new NotFoundException("Event not exist");
    }

    @Override
    public SessionPayload updateSessionInEvent(Long eventId, Long sessionId, SessionPayload sessionPayload) {
        Optional<Event> eventOptional = this.eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            Optional<Session> sessionOptional = event.getSchedule().getSessions()
                    .stream()
                    .filter(session -> session.getId().equals(sessionId))
                    .findFirst();
            if(sessionOptional.isPresent()){
                if (!this.convertDateToLocalDate(sessionPayload.getStartDateTime()).isBefore(event.getStartDateTime())
                        && !this.convertDateToLocalDate(sessionPayload.getEndDateTime()).isAfter(event.getEndDateTime())) {
                    Session session = sessionOptional.get();
                    session.setName(sessionPayload.getName());
                    session.setDescription(sessionPayload.getDescription());
                    session.setStartDateTime(sessionPayload.getStartDateTime());
                    session.setEndDateTime(sessionPayload.getEndDateTime());
                    this.eventRepository.save(event);
                    return sessionPayload;
                }else{
                    throw new InvalidCredentialsException("Session date has to be in the event range");
                }
            }
        }
        throw new NotFoundException("Event or session not exist");
    }

    @Override
    public String deleteSessionFromEvent(Long eventId, Long sessionId) {
        Optional<Event> eventOptional = this.eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            this.eventRepository.deleteSessionFromEventSchedule(eventOptional.get().getSchedule().getId(), sessionId);
            return "Session deleted or it was already not exist for this event";
        }
        throw new NotFoundException("This event not exist");
    }
    @Override
    public AttendanceResponseDTO getAttendanceForEvent(Long eventId) {
        Optional<Event> eventOptional = this.eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event events = eventOptional.get();
            Schedule schedule = events.getSchedule();
            List<Session> sessionList = schedule.getSessions();
            List<AttendanceRecord> attendenceRecord = new ArrayList<>();
            if(!sessionList.isEmpty()){
                for(Session session: sessionList){
                    List<Member> memberList = session.getMembers();
                    for(Member member: memberList){
                        attendenceRecord.add(AttendanceRecord.builder()
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
            return AttendanceResponseDTO.builder().count(attendenceRecord.size())
                    .attendanceRecordList(attendenceRecord)
                    .build();

        }
        return AttendanceResponseDTO.builder()
                .count(0)
                .attendanceRecordList(new ArrayList<>())
                .build();
    }
    private LocalDate convertDateToLocalDate(Date date){
        Instant instant = date.toInstant();

        // Convert Instant to LocalDateTime (using system default time zone)
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        // Extract LocalDate from LocalDateTime
       return localDateTime.toLocalDate();
    }
}
