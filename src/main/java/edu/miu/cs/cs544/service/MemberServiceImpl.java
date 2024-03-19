package edu.miu.cs.cs544.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.dto.AttendanceRecord;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Long> implements MemberService {
	
	private final MemberRepository memberRepository;

    @Override
    public List<Role> getAllRolesForMember(Long memberId) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            return member.getRoles();
        }
        return new ArrayList<>();
    }

    @Override
    public Role getRoleForMember(Long memberId, Long roleId) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            Optional<Role> roleOptional = member.getRoles().stream().filter(role -> role.getId().equals(roleId))
                    .findFirst();
            if(roleOptional.isPresent()){
                return roleOptional.get();
            }
        }
        return null;
    }

    @Override
    public Role createRole(Long memberId, Role role) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.getRoles().add(role);
            this.memberRepository.save(member);
            return role;
        }
        return null;
    }

    @Override
    public Role updateRole(Long memberId, Role inputRole) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            Optional<Role> roleOptional = member.getRoles().stream().filter(role -> role.getId().equals(inputRole.getId()))
                    .findFirst();
            roleOptional.ifPresent(role -> role.setRole(inputRole.getRole()));
            this.memberRepository.save(member);
            return inputRole;
        }
        return null;
    }

    @Override
    public String deleteRoleForMember(Long memberId, Long roleId) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()) {
            this.memberRepository.deleteRoleForMember(memberId,roleId);
            return "Deleted";
        }
        return "Member not found";
    }
    @Override
    public AttendanceResponseDTO attendanceForMemberByEvent(Long memberId, Long eventId) {
        List<Event> events = this.memberRepository.attendanceData(eventId);
        List<AttendanceRecord> attendanceRecordList = new ArrayList();
        for (Event event : events) {
            Schedule schedule = event.getSchedule();
            List<Session> sessions = schedule.getSessions();
            for (Session session : sessions) {
                List<Member> members = session.getMembers();
                for (Member member : members) {
                    if (member.getId().equals(memberId)) {
                        attendanceRecordList.add(AttendanceRecord.builder()
                                .memberId(member.getId())
                                .memberFirstName(member.getFirstName())
                                .memberLastName(member.getLastName())
                                .sessionId(session.getId())
                                .sessionDescription(session.getDescription())
                                .sessionName(session.getName())
                                .build());
                    }
                }
            }
        }
        return AttendanceResponseDTO.builder()
                .count(attendanceRecordList.size())
                .attendanceRecordList(attendanceRecordList)
                .build();
    }
	
    @Override
    public AttendanceResponseDTO getAttendence(Long memberId) {
        List<Session> sessions = this.memberRepository.fetchAllSessionForMember(memberId);
        List<AttendanceRecord> attendanceRecordList = new ArrayList<>();
        for(Session session:sessions){
            for(Member member:session.getMembers()){
                attendanceRecordList.add(
                        AttendanceRecord.builder()
                                .memberId(memberId)
                                .memberFirstName(member.getFirstName())
                                .memberLastName(member.getLastName())
                                .sessionId(session.getId())
                                .sessionDescription(session.getDescription())
                                .sessionName(session.getName())
                                .build()
                );
            }
        }
        return AttendanceResponseDTO.builder()
                .count(attendanceRecordList.size())
                .attendanceRecordList(attendanceRecordList)
                .build();
    }
    

}
