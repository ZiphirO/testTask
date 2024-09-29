package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.RequestContent;
import com.example.testTask.entities.VerifiedName;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestParser {
//src/main/resources/data/persons
    private final ObjectMapper MAPPER = new ObjectMapper();
    private final RegPersonService REG_PERSON_SERVICE;
    private final VerifiedNameService VERIFIED_NAME_SERVICE;

    public void parseRequest(RequestContent requestContent) throws NullPointerException {
        JsonNode content = requestContent.getContent();

        REG_PERSON_SERVICE.initRegPerson(RegPerson.builder().firstName(content.get("regPerson").get("firstName").asText())
                .middleName(content.get("regPerson").get("middleName").asText())
                .lastName(content.get("regPerson").get("lastName").asText()).build());

        VERIFIED_NAME_SERVICE.initVerifiedName(VerifiedName.builder().firstName(content.get("verifiedName").get("firstName").asText())
                .middleName(content.get("verifiedName").get("middleName").asText())
                .lastName(content.get("verifiedName").get("lastName").asText()).build());
    }
}
