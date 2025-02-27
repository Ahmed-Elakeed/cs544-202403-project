package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private LocalDate startDateTime;
    private LocalDate endDateTime;

    private AccountType accountType;
    private Schedule schedule;

}
