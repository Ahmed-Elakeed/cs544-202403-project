package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Location;
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
    private AccountType accountType;
    private Location location;
    private Event event;
}
