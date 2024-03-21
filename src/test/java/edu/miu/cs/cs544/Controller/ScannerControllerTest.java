package edu.miu.cs.cs544.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs.cs544.service.ScannerService;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(ScannerController.class)
@WebMvcTest(ScannerController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class ScannerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ScannerService scannerService;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void getAllScanRecords() throws Exception {
        // Given
        List<ScanRecordPayload> scanRecords = new ArrayList<>();
        // Create a sample scan record
        ScanRecordPayload sampleRecord = new ScanRecordPayload();
        sampleRecord.setId(1L);
        sampleRecord.setScanDateTime(LocalDateTime.parse("2024-04-01T10:30:00"));
        // Set member details
        MemberPayload member = new MemberPayload();
        member.setId(4L);
        member.setFirstName("John");
        member.setLastName("Doe");
        member.setEmail("johndoe@example.com");
        member.setBarcode(123456);
        sampleRecord.setMember(member);
        // Set session details
        SessionPayload session = new SessionPayload();
        session.setId(1L);
        session.setName("Kickoff event for Spring Festival");
        session.setDescription("Spring Festival Opening Ceremony");
        String dateString = "2024-04-01T15:00:00.000+00:00";

//        session.setStartDateTime(LocalDateTime.parse("2024-04-01T10:30:00"));
//        session.setEndDateTime(LocalDateTime.parse("2024-04-01T10:30:00"));
        sampleRecord.setSession(session);
        // Set event details
        EventPayload event = new EventPayload();
        event.setId(4L);
        event.setName("Spring Festival");
        event.setDescription("Annual campus festival");
        event.setStartDateTime(LocalDate.parse("2024-04-01"));
        event.setEndDateTime(LocalDate.parse("2024-04-03"));
        sampleRecord.setEvent(event);

        // Add the sample record to the list
        scanRecords.add(sampleRecord);

        Mockito.when(scannerService.getAllScanRecordsByScannerCode(Mockito.anyString()))
                .thenReturn(scanRecords);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/scanners/{scannerCode}/records", "123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(sampleRecord.getId()))
                .andExpect(jsonPath("$[0].scanDateTime").value("2024-04-01T10:30:00"))
                .andExpect(jsonPath("$[0].member.id").value(member.getId()))
                .andExpect(jsonPath("$[0].member.firstName").value(member.getFirstName()))
                .andExpect(jsonPath("$[0].member.lastName").value(member.getLastName()))
                .andExpect(jsonPath("$[0].member.email").value(member.getEmail()))
                .andExpect(jsonPath("$[0].member.barcode").value(member.getBarcode()))
                .andExpect(jsonPath("$[0].session.id").value(session.getId()))
                .andExpect(jsonPath("$[0].session.name").value(session.getName()))
                .andExpect(jsonPath("$[0].session.description").value(session.getDescription()))
//                .andExpect(jsonPath("$[0].session.startDateTime").value("2024-04-01T15:00:00.000Z"))
//                .andExpect(jsonPath("$[0].session.endDateTime").value("2024-04-01T17:00:00.000Z"))
                .andExpect(jsonPath("$[0].event.id").value(event.getId()))
                .andExpect(jsonPath("$[0].event.name").value(event.getName()))
                .andExpect(jsonPath("$[0].event.description").value(event.getDescription()))
                .andExpect(jsonPath("$[0].event.startDateTime").value("2024-04-01"))
                .andExpect(jsonPath("$[0].event.endDateTime").value("2024-04-03"));
    }

    @Test
    public void getScanRecordByScannerCodeAndRecordId_ReturnsScanRecordPayload() throws Exception {
        // Given
        String scannerCode = "123";
        Long recordId = 1L;
        ScanRecordPayload scanRecord = new ScanRecordPayload();
        scanRecord.setId(1L);
        scanRecord.setScanDateTime(LocalDateTime.parse("2024-04-01T10:30:00"));
        // Set member details
        MemberPayload member = new MemberPayload();
        member.setId(4L);
        member.setFirstName("John");
        member.setLastName("Doe");
        member.setEmail("johndoe@example.com");
        member.setBarcode(123456);
        scanRecord.setMember(member);
        // Set session details
        SessionPayload session = new SessionPayload();
        session.setId(1L);
        session.setName("Kickoff event for Spring Festival");
        session.setDescription("Spring Festival Opening Ceremony");
        String dateString = "2024-04-01T15:00:00.000+00:00";
//        session.setStartDateTime(LocalDateTime.parse("2024-04-01T10:30:00"));
//        session.setEndDateTime(LocalDateTime.parse("2024-04-01T10:30:00"));
        scanRecord.setSession(session);
        // Set event details
        EventPayload event = new EventPayload();
        event.setId(4L);
        event.setName("Spring Festival");
        event.setDescription("Annual campus festival");
        event.setStartDateTime(LocalDate.parse("2024-04-01"));
        event.setEndDateTime(LocalDate.parse("2024-04-03"));
        scanRecord.setEvent(event);

        Mockito.when(scannerService.getScanRecordByScannerCodeAndRecordId(scannerCode, recordId))
                .thenReturn(scanRecord);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/scanners/{scannerCode}/records/{recordId}", "123", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(scanRecord.getId()))
                .andExpect(jsonPath("$.scanDateTime").value("2024-04-01T10:30:00"))
                .andExpect(jsonPath("$.member.id").value(member.getId()))
                .andExpect(jsonPath("$.member.firstName").value(member.getFirstName()))
                .andExpect(jsonPath("$.member.lastName").value(member.getLastName()))
                .andExpect(jsonPath("$.member.email").value(member.getEmail()))
                .andExpect(jsonPath("$.member.barcode").value(member.getBarcode()))
                .andExpect(jsonPath("$.session.id").value(session.getId()))
                .andExpect(jsonPath("$.session.name").value(session.getName()))
                .andExpect(jsonPath("$.session.description").value(session.getDescription()))
//                .andExpect(jsonPath("$[0].session.startDateTime").value("2024-04-01T15:00:00.000Z"))
//                .andExpect(jsonPath("$[0].session.endDateTime").value("2024-04-01T17:00:00.000Z"))
                .andExpect(jsonPath("$.event.id").value(event.getId()))
                .andExpect(jsonPath("$.event.name").value(event.getName()))
                .andExpect(jsonPath("$.event.description").value(event.getDescription()))
                .andExpect(jsonPath("$.event.startDateTime").value("2024-04-01"))
                .andExpect(jsonPath("$.event.endDateTime").value("2024-04-03"));
    }
    @Test
    public void addRecordToScanner() throws Exception {
        // Given
        ScanRecordPayload scanRecordPayload = new ScanRecordPayload();
        scanRecordPayload.setId(1L);
        scanRecordPayload.setScanDateTime(LocalDateTime.of(2024, 4, 1, 10, 30));

        // properties for Member
        MemberPayload member = new MemberPayload();
        member.setId(4L);
        member.setFirstName("John");
        member.setLastName("Doe");
        member.setEmail("johndoe@example.com");
        member.setBarcode(123456);

        scanRecordPayload.setMember(member);
        // properties for session
        SessionPayload session = new SessionPayload();
        session.setId(1L);
        session.setName("Kickoff event for Spring Festival");
        session.setDescription("Spring Festival Opening Ceremony");
        session.setStartDateTime(new Date(2024, 4, 1));
        session.setEndDateTime(new Date(2024, 4, 1));
        scanRecordPayload.setSession(session);
        // properties for Event
        EventPayload event = new EventPayload();
        event.setId(4L);
        event.setName("Spring Festival");
        event.setDescription("Annual campus festival");
        event.setStartDateTime(LocalDate.of(2024, 4, 1));
        event.setEndDateTime(LocalDate.of(2024, 4, 3));
        event.setAccountType(null);
        event.setSchedule(null);
        scanRecordPayload.setEvent(event);

        String scannerCode = "123";
        String requestBody = objectMapper.writeValueAsString(scanRecordPayload);

        Mockito.when(scannerService.createRecordForScanner(scannerCode, scanRecordPayload)).thenReturn(scanRecordPayload);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.post("/scanners/{scannerCode}/records", scannerCode)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(scanRecordPayload.getId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.scanDateTime").value(scanRecordPayload.getScanDateTime().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.member.id").value(scanRecordPayload.getMember().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.member.firstName").value(scanRecordPayload.getMember().getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.member.lastName").value(scanRecordPayload.getMember().getLastName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.member.email").value(scanRecordPayload.getMember().getEmail()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.member.barcode").value(scanRecordPayload.getMember().getBarcode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.session.id").value(scanRecordPayload.getSession().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.session.name").value(scanRecordPayload.getSession().getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.session.description").value(scanRecordPayload.getSession().getDescription()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.session.startDateTime").value(scanRecordPayload.getSession().getStartDateTime().toString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.session.endDateTime").value(scanRecordPayload.getSession().getEndDateTime().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.event.id").value(scanRecordPayload.getEvent().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.event.name").value(scanRecordPayload.getEvent().getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.event.description").value(scanRecordPayload.getEvent().getDescription()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.event.startDateTime").value(scanRecordPayload.getEvent().getStartDateTime().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.event.endDateTime").value(scanRecordPayload.getEvent().getEndDateTime().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.event.accountType").value(scanRecordPayload.getEvent().getAccountType()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.event.schedule").value(scanRecordPayload.getEvent().getSchedule()))
                .andReturn();
    }

    @Test
    public void deleteScanRecordByScannerCodeAndRecordId() throws Exception {
        // Given
        String scannerCode = "123";
        Long recordId = 1L;

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.delete("/scanners/{scannerCode}/records/{recordId}", scannerCode, recordId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verify that the service method was called with the correct arguments
        Mockito.verify(scannerService, Mockito.times(1)).deleteScanRecordByScannerCodeAndRecordId(scannerCode, recordId);
    }
}