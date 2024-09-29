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
@Table(name = "verified_name")
public class VerifiedName {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "verified_name_id_generator")
    @SequenceGenerator(name = "verified_name_id_generator", sequenceName = "sq_verified_name_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String middleName;
}
