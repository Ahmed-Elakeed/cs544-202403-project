package edu.miu.cs.cs544.service;

import java.util.List;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;



public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Long>{

    List<Role> getAllRolesForMember(Long memberId);

    AttendanceResponseDTO getAttendence(Long id);

    Role getRoleForMember(Long memberId, Long roleId);

    Role createRole(Long memberId, Role role);

    Role updateRole(Long memberId, Role role);

    String deleteRoleForMember(Long memberId, Long roleId);
    
	AttendanceResponseDTO attendanceForMemberByEvent(Long memberId, Long eventId);
}
