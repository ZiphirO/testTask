package com.example.testTask.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "stop_factor")
public class StopFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stop_factor_id_generator")
    @SequenceGenerator(name = "stop_factor_id_generator", sequenceName = "sq_stop_factor_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private boolean personStopFactor;

    @OneToOne
    @JoinColumn(name = "reg_person_id")
    private RegPerson regPerson;

    public StopFactor(boolean personStopFactor, RegPerson regPerson) {
        this.personStopFactor = personStopFactor;
        this.regPerson = regPerson;
    }
}
