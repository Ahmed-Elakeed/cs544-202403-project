package edu.miu.cs.cs544.service;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.mapper.AccountToAccountPayloadMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


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
		assertThat(found.getAttendanceRecordList().get(0).getMemberId()).isEqualTo(memberId);
		assertThat(found.getAttendanceRecordList().get(0).getMemberFirstName()).isEqualTo("firstName");
		assertThat(found.getAttendanceRecordList().get(0).getSessionId()).isEqualTo(4);
		assertThat(found.getAttendanceRecordList().get(0).getSessionName()).isEqualTo("sess 4 event 1");
		assertThat(found.getAttendanceRecordList().get(1).getSessionId()).isEqualTo(5);
		assertThat(found.getAttendanceRecordList().get(1).getSessionName()).isEqualTo("sess name 5 event 1");
	}

    @Test
    void getAllRoleForMemberTest() {
        long memberId = 1L;
        Member member = new Member();
        Role role = new Role();
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        member.setRoles(roles);
        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

        List<Role> result = memberService.getAllRolesForMember(memberId);

        assertEquals(roles, result);
    }

    @Test
    void getRoleForMemberTest() {
        long memberId = 1L;
        long roleId = 2L;
        Member member = new Member();
        Role role = new Role();
        role.setId(roleId);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        member.setRoles(roles);
        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

        Role result = memberService.getRoleForMember(memberId, roleId);

        assertEquals(role, result);
    }

	@Test
	public void testGetAttendence() {
		Long memberId = 1l;
		AttendanceResponseDTO found = memberService.getMemberAttendance(memberId);
		assertThat(found.getCount()).isEqualTo(2);
		assertThat(found.getAttendanceRecordList().get(0).getSessionId()).isEqualTo(4);
		assertThat(found.getAttendanceRecordList().get(1).getSessionId()).isEqualTo(5);
	}
	@Test
	public void testGetAttendanceForNonExistentMember() {
		Long memberId = 100L; // Assuming member ID 100 does not exist
		AttendanceResponseDTO found = memberService.getMemberAttendance(memberId);
		assertThat(found.getCount()).isEqualTo(0);
		assertThat(found.getAttendanceRecordList().isEmpty());
	}
	@Test
	public void testGetAttendanceForMemberWithNoRecords() {
		Long memberId = 2L; // Assuming member ID 2 has no attendance records
		AttendanceResponseDTO found = memberService.getMemberAttendance(memberId);
		assertThat(found.getCount()).isEqualTo(0);
		assertThat(found.getAttendanceRecordList().isEmpty());
	}
	@Test
	public void testGetAttendanceWithNullMemberId() {
		Long memberId = null;
		AttendanceResponseDTO found = memberService.getMemberAttendance(memberId);
		assertThat(found.getCount()).isEqualTo(0);
		assertThat(found.getAttendanceRecordList().isEmpty());
	}


    @Test
    public void testCreateRole() {
        Long memberId = 1l;
        Role role3 = new Role(3l, "Role3", null);
        Role createdRole = memberService.createRole(memberId, role3);

        assertThat(createdRole).isEqualTo(role3);
        Member m = memberRepository.findById(memberId).get();
        assertThat(m.getRoles()).toString();
        verify(memberRepository, times(1)).save(m);
    }


    @Test
    void updateRoleTest() {
        long memberId = 1L;
        Role role = new Role();
        role.setId(1l);
        Member member = new Member();
        member.setId(1l);
        member.setRoles(new ArrayList<>());
        member.getRoles().add(role);
        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

        Role updatedRole = new Role();
        updatedRole.setId(2l);
        updatedRole.setRole("Updated Role");

        Role result = memberService.updateRole(memberId, updatedRole);

        assertEquals(updatedRole, result);
        verify(memberRepository, times(1)).save(member);
    }

    @Test
    public void testDeleteRoleForMember_WhenMemberExists() {
        Long memberId = 3L;
        Long roleId = 1L;
        Role role1 = new Role(roleId, "Role1", null);
        Member member = new Member();
        member.setRoles(new ArrayList<>(List.of(role1)));
        Mockito.when(memberRepository.findById(memberId))
                .thenReturn(Optional.of(member));

        String response = memberService.deleteRoleForMember(memberId, roleId);

        assertThat(response).isEqualTo("Deleted");
        verify(memberRepository, times(1)).deleteRoleForMember(memberId, roleId);
    }
}

