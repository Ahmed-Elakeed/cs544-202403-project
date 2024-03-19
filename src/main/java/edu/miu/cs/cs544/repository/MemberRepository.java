package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberRepository extends BaseRepository<Member, Long>{


    
	@Query(value = "select e from Event e inner join fetch e.schedule s inner join s.sessions ss where e.id = :eventId")
    List<Event> attendanceData(@Param(value = "eventId") Long eventId);

    @Query(value = "delete from member_roles mr where mr.member_id = :memberId and mr.role_id = :roleId",nativeQuery = true)
    @Modifying
    @Transactional
    void deleteRoleForMember(@Param(value = "memberId") Long memberId,@Param(value = "roleId") Long roleId);
    @Query(value = "select s from Session s left join fetch s.members m where m.id = :memberId")
    List<Session> fetchAllSessionForMember(@Param("memberId") Long memberId);
}
