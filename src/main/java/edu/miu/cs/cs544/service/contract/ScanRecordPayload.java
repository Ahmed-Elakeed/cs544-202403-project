package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Scanner;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScanRecordPayload implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDate scanDateTime;
    private Member recordOwner;
    private Scanner scanner;
}
