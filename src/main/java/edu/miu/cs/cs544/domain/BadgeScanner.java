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

    @Enumerated
    private AccountType accountType;

    @OneToOne
    private Location location;

    @OneToOne
    private Event event;
}
