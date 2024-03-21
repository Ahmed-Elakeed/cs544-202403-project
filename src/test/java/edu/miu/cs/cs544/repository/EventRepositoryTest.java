package edu.miu.cs.cs544.repository;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;


    @Test
    public void deleteSessionFromEventScheduleTest() {
        Long scheduleId = 1L;
        Long sessionId = 1L;
        eventRepository.deleteSessionFromEventSchedule(scheduleId, sessionId);
    }

}
