package edu.miu.cs.cs544.service.contract;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BadgeScannerPayload implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String accountType;
    private Long locationId;
    private Long eventId;
}
