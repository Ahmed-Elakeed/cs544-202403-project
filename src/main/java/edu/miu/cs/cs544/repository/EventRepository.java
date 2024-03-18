package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {

    @Query(value = "select new edu.miu.cs.cs544.service.contract.SessionPayload(s.id, s.name, s.description, s.startDateTime, s.endDateTime) from Session s where s.event.id != null")
    List<SessionPayload> fetchAllAttendedSessionForEvent(@Param(value = "eventId") Long eventId);

    @Query(value = "select new edu.miu.cs.cs544.service.contract.SessionPayload(s.id,s.name,s.description,s.startDateTime,s.endDateTime) from Session s where s.event.id = :eventId")
    List<SessionPayload> fetchAllSessionForEvent(@Param(value = "eventId") Long eventId);

    @Transactional
    @Modifying
    @Query(value = "delete from Session s where s.event.id = :eventId and s.id = :sessionId")
    void deleteSessionFromEvent(@Param(value = "eventId") Long eventId,@Param(value = "sessionId") Long sessionId);
}
