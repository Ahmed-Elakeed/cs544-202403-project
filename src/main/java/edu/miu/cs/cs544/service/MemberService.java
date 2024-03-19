package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.service.contract.MemberPayload;

public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Long>{

	AttendanceResponseDTO attendanceForMemberByEvent(Long memberId, Long eventId);
}
