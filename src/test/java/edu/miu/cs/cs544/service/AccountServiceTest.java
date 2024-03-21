package edu.miu.cs.cs544.service;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.mapper.JsonParser;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
public class AccountServiceTest {
    @MockBean
    private  AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {

        @Bean
        public AccountService accountService(AccountRepository accountRepository) {
            return new AccountServiceImpl(accountRepository);
        }
    }


    @MockBean
    private BaseMapper<Account, AccountPayload> accountToAccountPayloadMapper;

    @MockBean
    private BaseMapper<AccountPayload, Account> accountPayloadToAccountMapper;

    @BeforeEach
    public void setUp() throws Exception {
        String accRes="{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Dining Account\",\n" +
                "    \"description\": \"Main dining account\",\n" +
                "    \"accountType\": \"DINING\"\n" +
                "}";
        Account accountRes= JsonParser.parseJsonToObject(accRes,Account.class);
        Optional<Account> account= Optional.of(accountRes);
        Mockito.when(accountRepository.findById(1L))
                .thenReturn(account);

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
        Event event = new Event();
        event.setId(1L);
        event.setName("Event 1");
        event.setDescription("Event 1 description");
        event.setAccountType(AccountType.DINING);
        Schedule schedule = new Schedule();
        schedule.setId(1L);
        schedule.setDescription("Event 1 schedule");
        //schedule.setStartDateTime();
        event.setSchedule(schedule);
        Session session1 = new Session();
        session1.setId(1L);
        session1.setName("Event 1 session 1");
        session1.setDescription("Event 1 session 1");
        session1.setStartDateTime(start);
        session1.setEndDateTime(end);
        schedule.getSessions().add(session1);
        Member member = new Member();
        member.setId(1L);
        member.setBarcode(1);
        member.setFirstName("First Name");
        member.setLastName("Last Name");
        List<Member> members=new ArrayList<>();
        members.add(member);
        session1.setMembers(members);
        List<Event> eventList=new ArrayList<>();
        eventList.add(event);
        Mockito.when(accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(
                        AccountType.DINING,startDate,endDate))
                .thenReturn(eventList);

    }
    @Test
   public void attendanceForParticularAccountTypeWithDateRangeTest() {
        LocalDate startDate = LocalDate.parse("2024-04-01" );
        LocalDate endDate= LocalDate.parse("2024-04-03");
        AttendanceResponseDTO found = accountService.attendanceForParticularAccountTypeWithDateRange(1L,startDate,endDate);
        assertThat(found.getCount())
                .isEqualTo(1);
        assertThat(found.getAttendanceRecordList().size()).isEqualTo(1);
        assertThat(found.getAttendanceRecordList().get(0).getMemberId()).isEqualTo(1L);
        assertThat(found.getAttendanceRecordList().get(0).getSessionId()).isEqualTo(1L);
        assertThat(found.getAttendanceRecordList().get(0).getMemberFirstName()).isEqualTo("First Name");
        assertThat(found.getAttendanceRecordList().get(0).getMemberLastName()).isEqualTo("Last Name");

    }
    @Test
    public void testAccountService_WhenAccountNotFound() {
        // Given
        LocalDate startDate = LocalDate.parse("2024-04-01");
        LocalDate endDate = LocalDate.parse("2024-04-03");

        // When
        AttendanceResponseDTO result = accountService.attendanceForParticularAccountTypeWithDateRange(2L, startDate, endDate);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getCount()).isEqualTo(0);
        assertThat(result.getAttendanceRecordList()).isEmpty();
    }
    @Test
    public void testAccountService_WhenDateNotFound() {
        // Given
        LocalDate startDate = LocalDate.parse("2024-04-04");
        LocalDate endDate = LocalDate.parse("2024-04-06");

        // When
        AttendanceResponseDTO result = accountService.attendanceForParticularAccountTypeWithDateRange(2L, startDate, endDate);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getCount()).isEqualTo(0);
        assertThat(result.getAttendanceRecordList()).isEmpty();
    }
    @Test
    public void fetchAttendanceByInvalidAccountTypeWithDateRangeDataTest() {
        // Define an invalid account type
        AccountType invalidAccountType = null;
        LocalDateTime startDate = LocalDateTime.parse("2024-04-01T00:00:00" );
        LocalDateTime endDate= LocalDateTime.parse("2024-04-03T00:00:00");
        // Fetch attendance for the invalid account type
        List<Event> found = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(invalidAccountType, startDate, endDate);

        // Assert that the fetched list is empty
        assertThat(found).isEmpty();
    }
    @Test
    public void fetchAttendanceByValidAccountTypeWithNoEventsTest() {
        // Define a valid account type
        AccountType validAccountType = AccountType.DINING;

        // Fetch attendance for the valid account type with a date range where no events exist
        LocalDateTime startDateNoEvents = LocalDateTime.parse("2025-04-01T00:00:00");
        LocalDateTime endDateNoEvents = LocalDateTime.parse("2025-04-03T00:00:00");
        List<Event> found = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(validAccountType, startDateNoEvents, endDateNoEvents);

        // Assert that the fetched list is empty
        assertThat(found).isEmpty();
    }
    @Test
    public void fetchAttendanceByAccountTypeWithInvalidDateRangeTest() {
        // Define an invalid date range where start date is after end date
        LocalDateTime startDateInvalid = LocalDateTime.parse("2025-04-03T00:00:00");
        LocalDateTime endDateInvalid = LocalDateTime.parse("2025-04-01T00:00:00");

        // Fetch attendance with the invalid date range
        List<Event> found = accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(AccountType.DINING, startDateInvalid, endDateInvalid);

        // Assert that the fetched list is empty or handle the exception as appropriate
        // Example assertion for an empty list:
        assertThat(found).isEmpty();
    }


}
