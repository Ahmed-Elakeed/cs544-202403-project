package edu.miu.cs.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;

public interface MemberRepository extends BaseRepository<Member, Long>{

//	@Query("select s from Member m join m.sessions s join s.event e where m.id = :memberId and e.id = :eventId")
//	@Query("select s from Event e " +
//		       "join e.schedule sc " +
//		       "join sc.sessions s " +
//		       "where e.id = :eventId and s.id in " +
//		       "(select ses.id from Member m join m.sessions ses where m.id = :memberId)")
	@Query("select s from Event e " +
		       "join e.schedule sc " +
		       "join sc.sessions s " +
		       "join s.members m " +
		       "where e.id = :eventId and m.id = :memberId ")
	public List<Session> getAttendanceByMemberAndEvent(@Param("eventId") Long eventId, @Param("memberId") Long memberId);
	
}
