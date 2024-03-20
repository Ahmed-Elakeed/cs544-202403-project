package edu.miu.cs.cs544.Service;


import edu.miu.cs.cs544.Mapper.JsonParser;
import edu.miu.cs.cs544.service.EventService;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Appendable.class)
@AutoConfigureMockMvc
public class EventServiceTest {

    @Mock
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

}
