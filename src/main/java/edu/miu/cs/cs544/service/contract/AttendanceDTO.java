package edu.miu.cs.cs544.service.contract;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AttendanceDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private LocalDate date;
    private int present;
    private int absents;
    private int total;
}
