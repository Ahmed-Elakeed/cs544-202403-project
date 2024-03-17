package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate startDateTime;
    private LocalDate endDateTime;


    // Todo ->  decide if event will contain one or many schedule
    @OneToOne
    private Schedule schedule;

    @OneToMany
    private List<Member> members = new ArrayList<>();


}
