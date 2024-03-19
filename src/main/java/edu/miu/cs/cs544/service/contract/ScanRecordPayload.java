package edu.miu.cs.cs544.service.contract;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScanRecordPayload implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime scanDateTime;
    private MemberPayload member;
    private SessionPayload session;
    private EventPayload event;
}
