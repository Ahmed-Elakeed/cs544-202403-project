package edu.miu.cs.cs544.service;

import java.util.List;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.contract.MemberPayload;

public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Long>{

	List<Session> getAttendancebyMemberAndEvent(Long eventId, Long memberId);
}
