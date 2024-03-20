package edu.miu.cs.cs544.Service;


import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.Application;
import edu.miu.cs.cs544.controller.EventController;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.mapper.JsonParser;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.EventService;
import edu.miu.cs.cs544.service.EventServiceImpl;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Appendable.class)
//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class EventServiceTest {

    @Autowired
    EventService eventService;

   @MockBean
   EventRepository eventRepository;
    private List<SessionPayload> sessionList;

    @TestConfiguration
    static class EventServiceImplTestContextConfiguration {

        @Bean
        public EventService memberService(EventRepository eventRepository) {
            return new EventServiceImpl(eventRepository);
        }
    }
    @MockBean
    private BaseMapper<Event, EventPayload> accountToAccountPayloadMapper;

    @MockBean
    private BaseMapper<EventPayload, Event> accountPayloadToAccountMapper;

    private Event event;
    private Schedule schedule;

    private Session session1;
    private Member member;

    private List<Member> members;
    private List<Event> eventList;
    @BeforeEach
    public void setup() throws Exception {
        LocalDateTime startDate = LocalDateTime.parse("2024-04-01T00:00:00" );
        LocalDateTime endDate= LocalDateTime.parse("2024-04-03T00:00:00");
        Date start =null;
        Date end=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            start = dateFormat.parse("2024-04-01");
            end=dateFormat.parse("2024-04-01");
            // System.out.println("Parsed Date: " + startDate);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        event = new Event();
        event.setId(1L);
        event.setName("Event 1");
        event.setDescription("Event 1 description");
        event.setAccountType(AccountType.DINING);
        schedule = new Schedule();
        schedule.setId(1L);
        schedule.setDescription("Event 1 schedule");
        //schedule.setStartDateTime();
        event.setSchedule(schedule);
        session1 = new Session();
        session1.setId(1L);
        session1.setName("Event 1 session 1");
        session1.setDescription("Event 1 session 1");
        session1.setStartDateTime(start);
        session1.setEndDateTime(end);
        schedule.getSessions().add(session1);
        member = new Member();
        member.setId(1L);
        member.setBarcode(1);
        member.setFirstName("First Name");
        member.setLastName("Last Name");
        members=new ArrayList<>();
        members.add(member);
        session1.setMembers(members);
        eventList=new ArrayList<>();
        eventList.add(event);
        Mockito.when(eventRepository.findById(1L)).thenReturn(Optional.ofNullable(event));
    }

    @Test
    public void getAllSessionsForEventTest() throws Exception {
        Optional<Event> responseEvent = eventRepository.findById(1L);
        if(responseEvent.isPresent()){
            assertThat(responseEvent.get()).isEqualTo(event);
            assertThat(responseEvent.get().getSchedule()).isEqualTo(event.getSchedule());
            assertThat(responseEvent.get().getSchedule().getSessions()).isEqualTo(event.getSchedule().getSessions());
        }else{
            fail("Event not found");
        }
    }

    @Test
    public void getSessionForEventTest() throws Exception {
        Optional<Event> responseEvent = eventRepository.findById(1L);
        if(responseEvent.isPresent()){
            assertThat(responseEvent.get()).isEqualTo(event);
            assertThat(responseEvent.get().getSchedule()).isEqualTo(event.getSchedule());
            assertThat(responseEvent.get().getSchedule().getSessions().stream()
                    .filter(session -> session.getId().equals(1L))
                    .findFirst()).isEqualTo(event.getSchedule().getSessions().stream()
                    .filter(session -> session.getId().equals(1L))
                    .findFirst());
        }else{
            fail("Event not found");
        }
    }

    @Test
    public void saveSessionForEvent() throws Exception {
        Date startDate = new Date();
        Date endDate = new Date();
        SessionPayload sessionData = new SessionPayload(4L,"test session", "test session description",startDate, endDate);
        Mockito.when(eventService.saveSessionForEvent(1L, sessionData)).thenReturn(new SessionPayload(4L,"test session", "test session description",startDate, endDate));
        assertThat(sessionData).isEqualTo(eventService.saveSessionForEvent(1L, sessionData));
    }

    @Test
    public void updateSessionForEventTest(){
        Date startDate = new Date();
        Date endDate = new Date();
        SessionPayload sessionData = new SessionPayload(4L,"test session", "test session description",startDate, endDate);
        Mockito.when(eventService.updateSessionInEvent(4L, 1L, sessionData)).thenReturn(sessionData);
        assertThat(sessionData).isEqualTo(eventService.updateSessionInEvent(4L,1L, sessionData));
    }

    @Test
    public void deleteSessionFromEventTest(){

    }

}
