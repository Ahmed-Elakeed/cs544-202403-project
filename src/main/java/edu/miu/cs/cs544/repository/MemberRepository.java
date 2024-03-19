package edu.miu.cs.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;

public interface MemberRepository extends BaseRepository<Member, Long>{


	@Query(value = "select e from Event e inner join fetch e.schedule s inner join s.sessions ss where e.id = :eventId")
    List<Event> attendanceData(@Param(value = "eventId") Long eventId);	
}
