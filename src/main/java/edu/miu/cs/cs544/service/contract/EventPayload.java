package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Schedule;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EventPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private LocalDate startDateTime;
    private LocalDate endDateTime;


    private Schedule schedule;

}
