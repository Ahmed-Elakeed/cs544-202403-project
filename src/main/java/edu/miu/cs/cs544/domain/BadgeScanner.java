package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "badge_scanner")
public class BadgeScanner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Location location;

    @Enumerated
    private AccountType accountType;

    @OneToOne
    private Event event;
}
