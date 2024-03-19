package edu.miu.cs.cs544.Controller;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonObject;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {

    @Mock
    EventService eventService;

    @Mock
    EventRepository eventRepository;

    @Test
    public void getAttendanceByEventIdTest() {

        String expectedData = "{\"count\":3,\"attendanceRecordList\":[{\"memberId\":1,\"memberFirstName\":\"voijay\",\"memberLastName\":\"mano\",\"sessionId\":1,\"sessionName\":\"Session 1\",\"sessionDescription\":\"Monday\"},{\"memberId\":2,\"memberFirstName\":\"test\",\"memberLastName\":\"man\",\"sessionId\":1,\"sessionName\":\"Session 1\",\"sessionDescription\":\"Monday\"},{\"memberId\":3,\"memberFirstName\":\"rim\",\"memberLastName\":\"cok\",\"sessionId\":1,\"sessionName\":\"Session 1\",\"sessionDescription\":\"Monday\"}]}";
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(expectedData, JsonObject.class);
        ResponseEntity<?> response = ResponseEntity.ok(this.eventService.getAttendanceForEvent(1L));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jsonObject, response.getBody());
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
