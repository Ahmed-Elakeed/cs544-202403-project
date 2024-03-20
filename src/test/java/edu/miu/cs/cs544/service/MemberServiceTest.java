package edu.miu.cs.cs544.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.mapper.AccountToAccountPayloadMapper;


@ExtendWith(SpringExtension.class)
public class MemberServiceTest {
	
	@MockBean
	private MemberRepository memberRepository;
	
    @MockBean
    private BaseMapper<MemberPayload, Member> requestMapper;
	
	
	@Autowired
	private MemberService memberService;
	
	@MockBean
	private BaseMapper<Member, MemberPayload> baseMapper;
	
	@MockBean
	private AccountToAccountPayloadMapper accountToAccountPayloadMapper;

    @TestConfiguration
    static class MemberServiceImplTestContextConfiguration {

        @Bean
        public MemberService memberService(MemberRepository memberRepository) {
            return new MemberServiceImpl(memberRepository);
        }
    }
    
	@BeforeEach
	public void setUp() {
		Long eventId = 1l;
		Long memberId = 1l;
		List<Member> members = new ArrayList<Member>();
		Role r1 = new Role(1l, "Role1", null);
		Role r2 = new Role(2l, "Role2", null);
		List<Role> roles = new ArrayList<Role>();
		roles.add(r1);
		roles.add(r2);
		Member member1 = new Member(memberId, "firstName", "lasname", 1, "email"
				, roles);
		
		members.add(member1);
		Member member2 = new Member(2l, "firstName2", "lasname2", 2, "email2", null);
		
		Session s = new Session(4l, "sess 4 event 1", "description 4", null, null
				, members);
		Session s2 = new Session(5l, "sess name 5 event 1", "description 5", null, null
				, members);
		Session s3 = new Session(5l, "sess name 5 event 1", "description 5", null, null
				, Arrays.asList(member2));
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(s);
		sessions.add(s2);
		Schedule sch = new Schedule(1l, "Schedule 1 description", LocalDate.now(), LocalDate.now()
				, Arrays.asList(s, s2, s3));
		List<Event> events = new ArrayList<Event>();
		events.add(new Event(1l, "event1", "description", LocalDate.now(), LocalDate.now(), AccountType.CLASS, sch, null));
		Mockito.when(memberRepository.attendanceData(eventId))
			.thenReturn(events);
		Mockito.when(memberRepository.fetchAllSessionForMember(memberId))
			.thenReturn(sessions);
		Mockito.when(memberRepository.findById(memberId))
			.thenReturn(Optional.of(member1));
	}
	
	@Test
	public void testAttendanceForMemberByEvent() {
		Long eventId = 1l;
		Long memberId = 1l;
		AttendanceResponseDTO attendanceResponseDTO = AttendanceResponseDTO.builder()
                .count(1)
                .attendanceRecordList(null)
                .build();
		AttendanceResponseDTO found = memberService.attendanceForMemberByEvent(eventId, memberId);
		assertThat(found.getCount()).isEqualTo(2);
		assertThat(found.getAttendanceRecordList().get(0).getSessionId()).isEqualTo(4);
		assertThat(found.getAttendanceRecordList().get(1).getSessionId()).isEqualTo(5);
	}
	
}
