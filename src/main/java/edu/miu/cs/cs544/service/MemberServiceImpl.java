package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.contract.MemberPayload;

@Service
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Long> implements MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	public List<Session> getAttendancebyMemberAndEvent(Long eventId, Long memberId) {
		return memberRepository.getAttendanceByMemberAndEvent(eventId, memberId);
	}
}
