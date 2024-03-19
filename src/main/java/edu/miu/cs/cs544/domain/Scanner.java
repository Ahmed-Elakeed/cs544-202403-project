package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "scanner")
@Validated
public class Scanner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scannerCode;

    @Enumerated
    @NotBlank
    private AccountType accountType;

    @OneToOne
    private Location location;

    @OneToOne
    private Event event;
}
