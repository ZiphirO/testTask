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
@Table(name = "request_content")
public class RequestContent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_content_id_generator")
    @SequenceGenerator(name = "request_content_id_generator", sequenceName = "sq_request_content_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Type(com.vladmihalcea.hibernate.type.json.JsonType.class)
    @Column(name = "content", columnDefinition = "jsonb", nullable = false)
    private JsonNode content;

    public RequestContent(JsonNode content) {
        this.content = content;
    }
}
