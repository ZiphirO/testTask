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
    private final String[] NEW_REG_PERSON = new String[3];
    private final String[] NEW_VERIFIED_NAME = new String[3];

    public void parseRequest(RequestContent requestContent) throws NullPointerException {
        JsonNode content = requestContent.getContent();
        if (content.get("regPerson").hasNonNull("firstName")){
            NEW_REG_PERSON[0] = content.get("regPerson").get("firstName").asText();
        } else NEW_REG_PERSON[0] = null;
        if (content.get("regPerson").hasNonNull("middleName")){
            NEW_REG_PERSON[1] = content.get("regPerson").get("middleName").asText();
        } else NEW_REG_PERSON[1] = null;
        if (content.get("regPerson").hasNonNull("lastName")){
            NEW_REG_PERSON[2] = content.get("regPerson").get("lastName").asText();
        } else NEW_REG_PERSON[2] = null;
        REG_PERSON_SERVICE.initRegPerson(RegPerson.builder().firstName(NEW_REG_PERSON[0])
                .middleName(NEW_REG_PERSON[1]).lastName(NEW_REG_PERSON[2]).build());

        if (content.get("verified_name").hasNonNull("first_name")){
            NEW_VERIFIED_NAME[0] = content.get("verified_name").get("first_name").asText();
        } else NEW_VERIFIED_NAME[0] = null;
        if (content.get("verified_name").hasNonNull("other_name")){
            NEW_VERIFIED_NAME[1] = content.get("verified_name").get("other_name").asText();
        } else NEW_VERIFIED_NAME[1] = null;
        if (content.get("verified_name").hasNonNull("surname")){
            NEW_VERIFIED_NAME[2] = content.get("verified_name").get("surname").asText();
        } else NEW_VERIFIED_NAME[2] = null;
        VERIFIED_NAME_SERVICE.initVerifiedName(VerifiedName.builder().firstName(NEW_VERIFIED_NAME[0])
                .middleName(NEW_VERIFIED_NAME[1]).lastName(NEW_VERIFIED_NAME[2]).build());
    }
}
