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
@Table(name = "settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settings_id_generator")
    @SequenceGenerator(name = "settings_id_generator", sequenceName = "sq_settings_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double distanceRatioThreshold;

}
