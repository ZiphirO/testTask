package com.example.testTask.service.impl;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.RequestContent;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.RequestParserService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestParserImpl implements RequestParserService {

    private final RegPersonServiceImpl REG_PERSON_SERVICE;
    private final VerifiedNameServiceImpl VERIFIED_NAME_SERVICE;
    private final String[] NEW_REG_PERSON = new String[3];
    private final String[] NEW_VERIFIED_NAME = new String[3];

    @Override
    public void parseRequest(RequestContent requestContent) throws NullPointerException {
        JsonNode content = requestContent.getContent();
        JsonNode regPersonNode = content.get("regPerson");
        JsonNode creditBureauNode = content.get("creditBureau");
        JsonNode verifiedNameNode = creditBureauNode.get("verified_name");

        if (regPersonNode.has("firstName")){
            NEW_REG_PERSON[0] = regPersonNode.get("firstName").asText();
        } else NEW_REG_PERSON[0] = null;
        if (regPersonNode.has("middleName")){
            NEW_REG_PERSON[1] = regPersonNode.get("middleName").asText();
        } else NEW_REG_PERSON[1] = null;
        if (regPersonNode.has("lastName")){
            NEW_REG_PERSON[2] = regPersonNode.get("lastName").asText();
        } else NEW_REG_PERSON[2] = null;
        REG_PERSON_SERVICE.initRegPerson(RegPerson.builder().firstName(NEW_REG_PERSON[0])
                .middleName(NEW_REG_PERSON[1]).lastName(NEW_REG_PERSON[2]).build());

        if (verifiedNameNode.has("first_name")){
            NEW_VERIFIED_NAME[0] = verifiedNameNode.get("first_name").asText();
        } else NEW_VERIFIED_NAME[0] = null;
        if (verifiedNameNode.has("other_name")){
            NEW_VERIFIED_NAME[1] = verifiedNameNode.get("other_name").asText();
        } else NEW_VERIFIED_NAME[1] = null;
        if (verifiedNameNode.has("surname")){
            NEW_VERIFIED_NAME[2] = verifiedNameNode.get("surname").asText();
        } else NEW_VERIFIED_NAME[2] = null;
        VERIFIED_NAME_SERVICE.initVerifiedName(VerifiedName.builder().firstName(NEW_VERIFIED_NAME[0])
                .middleName(NEW_VERIFIED_NAME[1]).lastName(NEW_VERIFIED_NAME[2]).build());
    }
}
