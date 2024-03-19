package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private Integer barcode;
    @Column(unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "member_roles",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;
}
