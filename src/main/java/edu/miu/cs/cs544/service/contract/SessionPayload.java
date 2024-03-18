package edu.miu.cs.cs544.service.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class SessionPayload implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Date startDateTime;
    private Date endDateTime;
}
