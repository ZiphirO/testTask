package com.example.testTask.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
