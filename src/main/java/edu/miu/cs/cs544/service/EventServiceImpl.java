package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.exception.NotFoundException;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl extends BaseReadWriteServiceImpl<EventPayload, Event, Long> implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<SessionPayload> getAllSessionsForEvent(Long eventId) {
        return this.eventRepository.fetchAllSessionForEvent(eventId);
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
            Session session = new Session();
            session.setName(sessionPayload.getName());
            session.setDescription(sessionPayload.getDescription());
            session.setStartDateTime(sessionPayload.getStartDateTime());
            session.setEndDateTime(sessionPayload.getEndDateTime());
            session.setEvent(event);
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
            this.eventRepository.deleteSessionFromEvent(eventId,sessionId);
            return "Session deleted or it was already not exist for this event";
        }
        throw new NotFoundException("This event not exist");
    }

    @Override
    public List<SessionPayload> getAttendanceForEvent(Long eventId) {
        List<SessionPayload> sessionsList = this.eventRepository.fetchAllAttendedSessionForEvent(eventId);

        return null;
    }

}
