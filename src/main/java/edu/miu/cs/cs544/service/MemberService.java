package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;

import java.util.List;

public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Long>{
        AttendanceResponseDTO getAttendence(Long id);
}
