package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.mapper.JsonParser;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(AccountController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class AccountControllerTest {
    @Autowired
    MockMvc mock;

    @MockBean
    AccountService accountService;

    @MockBean
    AccountRepository repository;

    @Test
    public void test_attendanceForParticularAccountTypeWithDateRange() throws Exception {
        String accRes="{\n" +
                "    \"count\": 1,\n" +
                "    \"attendanceRecordList\": [\n" +
                "        {\n" +
                "            \"memberId\": 1,\n" +
                "            \"memberFirstName\": \"John\",\n" +
                "            \"memberLastName\": \"Doe\",\n" +
                "            \"sessionId\": 1,\n" +
                "            \"sessionName\": \"Kickoff event for Spring Festival\",\n" +
                "            \"sessionDescription\": \"Spring Festival Opening Ceremony\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        // Parse the string date to LocalDateTime
        LocalDate startDate = LocalDate.parse("2024-04-01" );
        LocalDate endDate= LocalDate.parse("2024-04-03");

        AttendanceResponseDTO attendanceResponseDTO= JsonParser.parseJsonToObject(accRes,AttendanceResponseDTO.class);
        Mockito.when(accountService.attendanceForParticularAccountTypeWithDateRange(
                1L,
                startDate,
                endDate
        )).thenReturn(attendanceResponseDTO);

        mock.perform(MockMvcRequestBuilders.get("/accounts/1/attendance/2024-04-01/2024-04-03").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.count").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[0].memberId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[0].memberFirstName").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[0].memberLastName").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[0].sessionId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[0].sessionName").value("Kickoff event for Spring Festival"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[0].sessionDescription").value("Spring Festival Opening Ceremony"));
    }
    @Test
    public void test_attendanceForParticularAccountTypeWithDateRange_NoAttendanceRecordsFound() throws Exception {
        // Given
        LocalDate startDate = LocalDate.parse("2024-04-01");
        LocalDate endDate = LocalDate.parse("2024-04-03");
        String accRes = "{ \"count\": 0, \"attendanceRecordList\": [] }";
        AttendanceResponseDTO attendanceResponseDTO = JsonParser.parseJsonToObject(accRes, AttendanceResponseDTO.class);
        Mockito.when(accountService.attendanceForParticularAccountTypeWithDateRange(1L, startDate, endDate)).thenReturn(attendanceResponseDTO);

        // When-Then
        mock.perform(MockMvcRequestBuilders.get("/accounts/1/attendance/2024-04-01/2024-04-03").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.count").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList").isEmpty());
    }

    @Test
    public void test_attendanceForParticularAccountTypeWithDateRange_StartDateAfterEndDate() throws Exception {
        // Given
        LocalDate startDate = LocalDate.parse("2024-04-03");
        LocalDate endDate = LocalDate.parse("2024-04-01");

        // When-Then
        mock.perform(MockMvcRequestBuilders.get("/accounts/1/attendance/2024-04-03/2024-04-01").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void test_attendanceForParticularAccountTypeWithDateRange_EmptyAccountID() throws Exception {
        // Given
        LocalDate startDate = LocalDate.parse("2024-04-01");
        LocalDate endDate = LocalDate.parse("2024-04-03");

        // When-Then
        mock.perform(MockMvcRequestBuilders.get("/badge-system/accounts/attendance/2024-04-01/2024-04-03")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}