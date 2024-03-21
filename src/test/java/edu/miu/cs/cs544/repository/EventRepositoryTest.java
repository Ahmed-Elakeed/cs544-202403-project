package edu.miu.cs.cs544.repository;


import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.domain.Session;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;

    @Test
    @Transactional
    public void testDeleteSessionFromEventSchedule() {
        Event event = new Event();
        Schedule schedule = new Schedule();
        Session session = new Session();
        session.setName("Test Session");

        entityManager.persist(session);
        schedule.getSessions().add(session);
        entityManager.persist(schedule);
        event.setSchedule(schedule);
        entityManager.persist(event);
        assertThat(entityManager.find(Session.class, session.getId())).isNotNull();
        eventRepository.deleteSessionFromEventSchedule(event.getSchedule().getId(), session.getId());

        entityManager.flush();
        entityManager.clear();

        Schedule updatedSchedule = entityManager.find(Schedule.class, schedule.getId());
        assertThat(updatedSchedule.getSessions()).isEmpty();
    }


}
