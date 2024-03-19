package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.dto.AttendanceRecord;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Long> implements MemberService {

    private final MemberRepository memberRepository;

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
