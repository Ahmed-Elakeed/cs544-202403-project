package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MemberRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private MemberRepository memberRepository;


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
		entityManager.persist(member);

		entityManager.persist(session2);

		entityManager.flush();

		List<Event> foundSessions = memberRepository.attendanceData(event.getId());
//        assertThat(foundSessions).hasSize(1);
//        assertThat(foundSessions.get(0).getName()).isEqualTo(session2.getName());


	}

	@Test
	public void testDeleteRoleForMember() {
		// Assume Member and Role entities are correctly set up in the context

		Role r1 = new Role(null, "Role1", null);
		Role r2 = new Role(null, "Role2", null);
		entityManager.persist(r1);
		entityManager.persist(r2);
		Member member = new Member(null, "firstName", "lasname", 1, "email"
				, new ArrayList<Role>());
		member.getRoles().add(r1);
		member.getRoles().add(r2);
		entityManager.persist(member);
		entityManager.flush();

		assertNotNull(entityManager.find(Member.class, member.getId()));


		assertTrue(entityManager.find(Member.class, member.getId()).getRoles().contains(r1));
		assertTrue(entityManager.find(Member.class, member.getId()).getRoles().contains(r2));

		memberRepository.deleteRoleForMember(member.getId(), r1.getId());
		entityManager.flush();
		Member persistedMember = entityManager.find(Member.class, member.getId());
		assertNotNull(persistedMember);
		entityManager.refresh(persistedMember);
		assertFalse(persistedMember.getRoles().contains(r1));
		assertTrue(persistedMember.getRoles().contains(r2));
	}
}
