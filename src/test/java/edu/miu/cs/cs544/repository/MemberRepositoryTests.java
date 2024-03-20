package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private MemberRepository memberRepository;

	List<Session> sessionList=new ArrayList<>();

//	@BeforeEach
//	void setup(){
//
//		//sessionList.add(session1);
//		//sessionList.add(session2);
//
//	}

	@Test
	public void whenGetAttendanceByMemberAndEvent_thenReturnsSessions() {
		Event event = new Event();
		event.setName("Event 1");
		event.setDescription("Event 1 description");
		event.setAccountType(AccountType.CLASS);
		System.out.println();
		System.out.println("Event 1 ID " + event.getId());

		Schedule schedule = new Schedule();
		schedule.setDescription("Event 1 schedule");
		event.setSchedule(schedule);

		Session session1 = new Session();
		session1.setName("Event 1 session 1");
		session1.setDescription("Event 1 session 1");
		entityManager.persist(session1);
		Session session2 = new Session();
		session2.setName("Event 1 session 2");
		session2.setDescription("Event 1 session 2");

		schedule.getSessions().add(session1);
		schedule.getSessions().add(session2);

		entityManager.persist(schedule);
		entityManager.persist(event);

		Member member = new Member();
		member.setBarcode(1);
		member.setFirstName("First Name");
		member.setLastName("Last Name");

		session2.getMembers().add(member);
		session1.getMembers().add(member);
		entityManager.persist(member);

		entityManager.persist(session2);

		entityManager.flush();
		List<Event> foundSessions = memberRepository.attendanceData(event.getId());
		assertThat(foundSessions).hasSize(1);
//        assertThat(foundSessions.get(0).getName()).isEqualTo(session2.getName());


	}

	@Test
	public void getMemberAttendenceTest(){
		Session session1 = new Session();
		session1.setName("Event 1 session 1");
		session1.setDescription("Event 1 session 1");
		entityManager.persist(session1);
		Member member = new Member();
		member.setBarcode(1);
		member.setFirstName("First Name");
		member.setLastName("Last Name");
		session1.getMembers().add(member);
		entityManager.persist(member);
		entityManager.flush();
		List<Session> sessionList=new ArrayList<>();
		sessionList.add(session1);
		// when
		List<Session> found = memberRepository.fetchAllSessionForMember(member.getId());
		// then
		assertThat(found.size())
				.isEqualTo(1);
		assertThat(sessionList.get(0).getName())
				.isEqualTo("Event 1 session 1");
		assertThat(sessionList.get(0).getDescription())
				.isEqualTo("Event 1 session 1");
		assertThat(sessionList.get(0).getMembers().get(0).getFirstName())
				.isEqualTo("First Name");
	}
	@Test
	public void when_memberId_have_no_session() {
		Session session1 = new Session();
		session1.setName("Event 1 session 1");
		session1.setDescription("Event 1 session 1");
		entityManager.persist(session1);
		Member member = new Member();
		member.setBarcode(1);
		member.setFirstName("First Name");
		member.setLastName("Last Name");
		entityManager.persist(member);
		entityManager.flush();
		List<Session> sessionList=new ArrayList<>();
		sessionList.add(session1);
		// when

		// then
		// When member has no associated sessions
		List<Session> foundSessions = memberRepository.fetchAllSessionForMember(member.getId());
		// Then
	    assertThat(foundSessions).isEmpty();
	}


}
