package edu.miu.cs.cs544.Controller;

import edu.miu.cs.cs544.controller.AccountController;
import edu.miu.cs.cs544.controller.EventController;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.mapper.JsonParser;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.EventService;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
@AutoConfigureMockMvc(addFilters = false)
//@SpringBootTest(classes = Appendable.class)
public class EventControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    EventService eventService;
    @MockBean
    EventRepository eventRepository;

    private AttendanceResponseDTO expectedData;
    @Test
    public void getAttendanceForEventTest() throws Exception {
        String jsonArray = "{\"count\":3,\"attendanceRecordList\":[{\"memberId\":1,\"memberFirstName\":\"voijay\",\"memberLastName\":\"mano\",\"sessionId\":1,\"sessionName\":\"Session 1\",\"sessionDescription\":\"Monday\"}]}";
        expectedData = JsonParser.parseJsonToObject(jsonArray, AttendanceResponseDTO.class);
        Mockito.when(eventService.getAttendanceForEvent(1L)).thenReturn(expectedData);

        mockMvc.perform(MockMvcRequestBuilders.get("/events/{eventId}/attendance", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.count").value(3)) // Verify the count
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendanceRecordList[0].memberId").value(1));
    }

    @Test
    public void getAllSessionsForEventTest() throws Exception {
        String data = "{\"id\":1,\"name\":\"Session 1\",\"description\":\"Monday\",\"startDateTime\":\"2024-03-18T22:30:23.000+00:00\",\"endDateTime\":\"2024-03-19T01:30:00.000+00:00\"}";
        SessionPayload expectedData = JsonParser.parseJsonToObject(data, SessionPayload.class);
        Mockito.when(eventService.getSessionForEvent(1L, 1L)).thenReturn(expectedData);

        mockMvc.perform(MockMvcRequestBuilders.get("/events/1/sessions/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Session 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Monday"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDateTime").value("2024-03-18T22:30:23.000+00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDateTime").value("2024-03-19T01:30:00.000+00:00"));
    }

}
