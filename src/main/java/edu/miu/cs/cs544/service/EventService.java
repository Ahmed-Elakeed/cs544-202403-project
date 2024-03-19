package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.service.contract.AttendanceDTO;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;

import java.util.List;

public interface EventService extends BaseReadWriteService<EventPayload, Event, Long>{

     List<SessionPayload> getAllSessionsForEvent(Long eventId);

     SessionPayload getSessionForEvent(Long eventId, Long sessionId);

     SessionPayload saveSessionForEvent(Long eventId, SessionPayload sessionPayload);

     SessionPayload updateSessionInEvent(Long eventId, Long sessionId, SessionPayload sessionPayload);

     String deleteSessionFromEvent(Long eventId, Long sessionId);

     AttendanceResponseDTO getAttendanceForEvent(Long eventId);
}
