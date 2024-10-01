package com.example.testTask.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "reg_person")
public class RegPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_person_id_generator")
    @SequenceGenerator(name = "reg_person_id_generator", sequenceName = "sq_reg_person_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String middleName;


}
