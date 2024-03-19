package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends BaseRepository<Member, Long>{
    @Query(value = "select s from Session s left join fetch s.members m where m.id = :memberId")
    List<Session> fetchAllSessionForMember(@Param("memberId") Long memberId);
}
