package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.Mapper.JsonParser;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Appendable.class)
@AutoConfigureMockMvc
public class EventServiceTest {

    @Autowired
    EventService eventService;

//    @Mock
//    EventController eventController;
    private List<SessionPayload> sessionList;



    @Before
    public void setup() throws Exception {
        String jsonArray = "[{\"id\":1,\"name\":\"Session 1\",\"description\":\"Monday\",\"startDateTime\":\"2024-03-18T22:30:23.000+00:00\",\"endDateTime\":\"2024-03-19T01:30:00.000+00:00\"},{\"id\":2,\"name\":\"Session 2\",\"description\":\"Tuesday\",\"startDateTime\":\"2024-03-18T21:36:21.000+00:00\",\"endDateTime\":\"2024-03-18T21:36:11.000+00:00\"}]";
        sessionList = JsonParser.parseJsonToList(jsonArray, SessionPayload.class);
        Mockito.when(eventService.getAllSessionsForEvent(1L)).thenReturn(sessionList);
    }

    @Test
    public void getAllSessionsForEventTest() throws Exception {
        assertThat(sessionList).isEqualTo(eventService.getAllSessionsForEvent(1L));
    }

    @Test
    public void getSessionForEventTest() throws Exception {
        String data = "{\"id\":1,\"name\":\"Session 1\",\"description\":\"Monday\",\"startDateTime\":\"2024-03-18T22:30:23.000+00:00\",\"endDateTime\":\"2024-03-19T01:30:00.000+00:00\"}";
        SessionPayload expectedData = JsonParser.parseJsonToObject(data, SessionPayload.class);
        Mockito.when(eventService.getSessionForEvent(1L, 1L)).thenReturn(expectedData);
        assertThat(expectedData).isEqualTo(eventService.getSessionForEvent(1L, 1L));
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
