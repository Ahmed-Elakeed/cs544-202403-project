package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.service.contract.MemberPayload;

import java.util.List;



public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Long>{


    
	AttendanceResponseDTO attendanceForMemberByEvent(Long memberId, Long eventId);

    List<Role> getAllRolesForMember(Long memberId);
    AttendanceResponseDTO getMemberAttendance(Long id);

    Role getRoleForMember(Long memberId,Long roleId);

    Role updateRole(Long memberId, Role role);
    Role createRole(Long memberId, Role role);
    String deleteRoleForMember(Long memberId,Long roleId);
}
