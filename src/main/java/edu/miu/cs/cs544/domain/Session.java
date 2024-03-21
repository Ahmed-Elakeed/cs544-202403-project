package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date startDateTime;
    private Date endDateTime;

    @ManyToMany
    @JoinTable(name = "member_sessions",
            inverseJoinColumns = {@JoinColumn(name = "member_id")},
            joinColumns = {@JoinColumn(name = "session_id")}
    )
    private List<Member> members = new ArrayList<>();
}
