package edu.miu.cs.cs544.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
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
}
