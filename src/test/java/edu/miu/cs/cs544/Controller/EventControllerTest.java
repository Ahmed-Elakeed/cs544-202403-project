package edu.miu.cs.cs544.Controller;

import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.EventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    EventService eventService;

    @Mock
    EventRepository eventRepository;


    @Test
    public void getAttendanceByEventIdTest() throws Exception {

//        String expectedData = "{\"count\":3,\"attendanceRecordList\":[{\"memberId\":1,\"memberFirstName\":\"voijay\",\"memberLastName\":\"mano\",\"sessionId\":1,\"sessionName\":\"Session 1\",\"sessionDescription\":\"Monday\"},{\"memberId\":2,\"memberFirstName\":\"test\",\"memberLastName\":\"man\",\"sessionId\":1,\"sessionName\":\"Session 1\",\"sessionDescription\":\"Monday\"},{\"memberId\":3,\"memberFirstName\":\"rim\",\"memberLastName\":\"cok\",\"sessionId\":1,\"sessionName\":\"Session 1\",\"sessionDescription\":\"Monday\"}]}";
////
//        AttendanceResponseDTO jsonObject = JsonParser.parseJsonToObject(expectedData, AttendanceResponseDTO.class);
////        ResponseEntity<?> response = ResponseEntity.ok(eventService.getAttendanceForEvent(1L));
////        System.out.print(jsonObject+  " ------------------------> " + response.getBody());
//        Mockito.when(eventService.getAttendanceForEvent(1L)).thenReturn(jsonObject);
//        mockMvc.perform(MockMvcRequestBuilders.get("/events/{eventId}/attendance", 1))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.count").value("3"));
    }

    @Test
    public void getAllSessionForEventTest(){
        //given
        Long eventId = 1L;

        //response
        ResponseEntity<?> response = ResponseEntity.ok(this.eventService.getAttendanceForEvent(eventId));

        //expected data


    }
}
