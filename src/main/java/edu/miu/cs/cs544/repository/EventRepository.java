package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {

    @Transactional
    @Modifying
    @Query(value = "delete from session s where s.id = :sessionId AND s.schedule_id = :scheduleId", nativeQuery = true)
    void deleteSessionFromEventSchedule(@Param(value = "scheduleId") Long scheduleId,@Param(value = "sessionId") Long sessionId);
}
