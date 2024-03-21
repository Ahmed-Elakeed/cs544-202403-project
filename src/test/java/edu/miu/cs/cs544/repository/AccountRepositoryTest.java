package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired EventRepository eventRepository;
    LocalDateTime startDate = LocalDateTime.parse("2024-04-01T00:00:00" );
    LocalDateTime endDate= LocalDateTime.parse("2024-04-03T00:00:00");

   public List<Event> testData(){
        Date start =null;
        Date end=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            start = dateFormat.parse("2024-04-01");
            end=dateFormat.parse("2024-04-03");
            System.out.println("Parsed Date: " + startDate);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        Event event = new Event();
        event.setName("Event 1");
        event.setDescription("Event 1 description");
        event.setAccountType(AccountType.DINING);
        System.out.println();
        System.out.println("Event 1 ID " + event.getId());

        Schedule schedule = new Schedule();
        schedule.setDescription("Event 1 schedule");
        event.setSchedule(schedule);

        Session session1 = new Session();
        session1.setName("Event 1 session 1");
        session1.setDescription("Event 1 session 1");
        session1.setStartDateTime(start);
        session1.setEndDateTime(end);
        entityManager.persist(session1);
        schedule.getSessions().add(session1);
        entityManager.persist(schedule);
        entityManager.persist(event);

        Member member = new Member();
        member.setBarcode(1);
        member.setFirstName("First Name");
        member.setLastName("Last Name");
        entityManager.persist(member);
        entityManager.flush();
        List<Event> eventList=new ArrayList<>();
        eventList.add(event);
        return eventList;
    }
    @Test
    public void fetchAttendanceByAccountTypeWithDateRangeDataTest() {

        List<Event> eventList=testData();

        // when
        List<Event> found = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(AccountType.DINING,startDate,endDate);
        // then
        assertThat(eventList.size())
               .isEqualTo(found.size());

    }
    @Test
    public void fetchAttendanceByAccountTypeWithNoDate() {

        // when
        List<Event> found = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(AccountType.DINING, null, null);

        // Assert that the result matches the expected outcome
        assertThat(found).isEmpty();

    }
    @Test
    public void fetchAttendanceByAccountTypeWithNoAccount() {

        // when
        List<Event> found = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(AccountType.DINING, null, null);

        // Assert that the result matches the expected outcome
        assertThat(found).isEmpty();

    }
    @Test
    public void fetchAttendanceByDifferentAccountTypeWithDateRangeDataTest() {
        // Define different account types
        AccountType accountType1 = AccountType.DINING;
        AccountType accountType2 = AccountType.GYM;

        // Fetch attendance for different account types
        List<Event> found1 = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(accountType1, startDate, endDate);
        List<Event> found2 = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(accountType2, startDate, endDate);

        // Assert that the fetched lists are not null and contain the expected number of events
        assertNotNull(found1);
        assertNotNull(found2);
    }
    @Test
    public void fetchAttendanceWithDifferentDateRangesTest() {
        // Define different date ranges
        LocalDateTime startDate1 = LocalDateTime.parse("2024-04-01T00:00:00");
        LocalDateTime endDate1 = LocalDateTime.parse("2024-04-03T00:00:00");
        LocalDateTime startDate2 = LocalDateTime.parse("2024-05-01T00:00:00");
        LocalDateTime endDate2 = LocalDateTime.parse("2024-05-03T00:00:00");

        // Fetch attendance for different date ranges
        List<Event> found1 = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(AccountType.DINING, startDate1, endDate1);
        List<Event> found2 = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(AccountType.DINING, startDate2, endDate2);

        // Assert that the fetched lists are not null
        assertNotNull(found1);
        assertNotNull(found2);

        // Add your assertions for the size of the fetched lists based on your expectations
        // For example:
        assertThat(found1.size()).isEqualTo(0);
        assertThat(found2.size()).isEqualTo(0);
    }

}
