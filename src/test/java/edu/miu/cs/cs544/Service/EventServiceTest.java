package edu.miu.cs.cs544.Service;


import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.EventService;
import edu.miu.cs.cs544.service.EventServiceImpl;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import edu.miu.cs.cs544.service.mapper.SessionMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
public class EventServiceTest {

    @Autowired
    EventService eventService;

   @MockBean
   EventRepository eventRepository;

    @MockBean
    MemberRepository memberRepository;
    private List<SessionPayload> sessionList;

    @TestConfiguration
    static class EventServiceImplTestContextConfiguration {

        @Bean
        public EventService eventService(EventRepository eventRepository, MemberRepository memberRepository) {
            return new EventServiceImpl(eventRepository, memberRepository);
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

    LocalDate startDate = LocalDate.parse("2024-04-01" );
    LocalDate endDate= LocalDate.parse("2024-04-03");
    Date start =null;
    Date end=null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeEach
    public void setup() throws Exception {
        try {
            start = dateFormat.parse("2024-04-01");
            end=dateFormat.parse("2024-04-02");
            // System.out.println("Parsed Date: " + startDate);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }

        event = new Event();
        event.setId(1L);
        event.setName("Event 1");
        event.setDescription("Event 1 description");
        event.setAccountType(AccountType.DINING);
        event.setStartDateTime(startDate);
        event.setEndDateTime(endDate);
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = dateFormat.parse("2024-04-01");
            end = dateFormat.parse("2024-04-02");
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        SessionPayload sessionData = new SessionPayload(1L,"test session", "test session description",start, end);
        Mockito.when(eventService.saveSessionForEvent(1L, sessionData))
                .thenReturn(SessionMapper.toSessionPayload(session1));
        Optional<Event> eventById = eventRepository.findById(1L);
        assertThat(eventById.get().getSchedule().getSessions().add(session1)).isEqualTo(true);
    }

    @Test
    public void updateSessionForEventTest(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = dateFormat.parse("2024-04-01");
            end = dateFormat.parse("2024-04-02");
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        Optional<Event> responseEvent = eventRepository.findById(1L);
        responseEvent.ifPresent(value -> assertThat(value).isEqualTo(event));
        SessionPayload sessionData = new SessionPayload(1L,"test session", "test session description",start, end);
        Mockito.when(eventService.updateSessionInEvent(1L, 1L, sessionData))
                .thenReturn(SessionMapper.toSessionPayload(session1));

    }

    @Test
    public void deleteSessionFromEventTest(){
        Optional<Event> responseEvent = eventRepository.findById(1L);
        Mockito.doNothing().when(eventRepository).deleteSessionFromEventSchedule(1L, 1L);
        if(responseEvent.isPresent()){
            assertThat(responseEvent.get()).isEqualTo(event);
            assertThat(responseEvent.get().getSchedule()).isEqualTo(event.getSchedule());
            assertThat(responseEvent.get().getSchedule().getSessions()).isEqualTo(event.getSchedule().getSessions());
        }else{
            fail("Event not found");
        }
        assertThat("Session deleted or it was already not exist for this event").isEqualTo(eventService.deleteSessionFromEvent(1L, 1L));
    }

}
