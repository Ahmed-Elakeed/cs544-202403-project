package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Location;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScannerPayload implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String scannerCode;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private LocationPayload location;
    private EventPayload event;
}
