package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.dto.AttendanceRecord;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import edu.miu.cs.cs544.service.MemberService;
import edu.miu.cs.cs544.dto.AttendanceRecord;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@AutoConfigureMockMvc(addFilters = false)
public class MemberControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MemberService memberService;
	

	@Test 
	public void testAttendanceForMemberByEvent() throws Exception { 
        Long memberId = 1L;
        Long eventId = 1L;
        
        List<AttendanceRecord> attendanceRecords = new ArrayList<AttendanceRecord>();
        attendanceRecords.add(new AttendanceRecord(1l, "fn1", "ln1", 1l, "sess1", ""));
        attendanceRecords.add(new AttendanceRecord(2l, "fn2", "ln2", 2l, "sess2", ""));
        AttendanceResponseDTO response = new AttendanceResponseDTO(2, attendanceRecords);
        Mockito.when(memberService.attendanceForMemberByEvent(memberId, eventId)).thenReturn(response);

        mockMvc.perform(get("/members/{memberId}/events/{eventId}/attendance", memberId, eventId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$.count").value(2))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[0].memberId").value(1))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[1].memberId").value(2))
        		;
    } 
}
