package com.example.testTask.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "credit_bureau")
public class CreditBureau {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_bureau_id_generator")
    @SequenceGenerator(name = "credit_bureau_id_generator", sequenceName = "sq_credit_bureau_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Type(com.vladmihalcea.hibernate.type.json.JsonType.class)
    @Column(name = "content", columnDefinition = "jsonb", nullable = false)
    private JsonNode content;

    public CreditBureau(JsonNode content) {
        this.content = content;
    }
}
