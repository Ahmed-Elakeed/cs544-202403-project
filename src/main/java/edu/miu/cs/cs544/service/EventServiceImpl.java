package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.exception.NotFoundException;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import edu.miu.cs.cs544.service.mapper.SessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
            List<Session> sessionList=new ArrayList<>();
            Session session = new Session();
            session.setName(sessionPayload.getName());
            session.setDescription(sessionPayload.getDescription());
            session.setStartDateTime(sessionPayload.getStartDateTime());
            session.setEndDateTime(sessionPayload.getEndDateTime());
//            session.setEvent(event);
            event.getSchedule().getSessions().add(session);
            this.eventRepository.save(event);
            return sessionPayload;
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
                Session session = sessionOptional.get();
                session.setName(sessionPayload.getName());
                session.setDescription(sessionPayload.getDescription());
                session.setStartDateTime(sessionPayload.getStartDateTime());
                session.setEndDateTime(sessionPayload.getEndDateTime());
                this.eventRepository.save(event);
                return sessionPayload;
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
    public List<SessionPayload> getAttendanceForEvent(Long eventId) {
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

}
