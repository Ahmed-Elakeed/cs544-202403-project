package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "scanner")
public class Scanner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String scannerCode;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private AccountType accountType;

    @OneToOne
    private Location location;

    @OneToOne
    private Event event;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "scanner_id")
    List<ScanRecord> scanRecordList = new ArrayList<>();
}
