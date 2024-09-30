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

    private final RegPersonServiceImpl regPersonService;
    private final VerifiedNameServiceImpl verifiedNameService;
    private final String[] newRegPerson = new String[3];
    private final String[] newVerifiedName = new String[3];

    @Override
    public void parseRequest(RequestContent requestContent) throws NullPointerException {
        JsonNode content = requestContent.getContent();
        JsonNode regPersonNode = content.get("regPerson");
        JsonNode creditBureauNode = content.get("creditBureau");
        JsonNode verifiedNameNode = creditBureauNode.get("verified_name");

        if (regPersonNode.has("firstName")){
            newRegPerson[0] = regPersonNode.get("firstName").asText();
        } else newRegPerson[0] = null;
        if (regPersonNode.has("middleName")){
            newRegPerson[1] = regPersonNode.get("middleName").asText();
        } else newRegPerson[1] = null;
        if (regPersonNode.has("lastName")){
            newRegPerson[2] = regPersonNode.get("lastName").asText();
        } else newRegPerson[2] = null;
        regPersonService.initRegPerson(RegPerson.builder().firstName(newRegPerson[0])
                .middleName(newRegPerson[1]).lastName(newRegPerson[2]).build());

        if (verifiedNameNode.has("first_name")){
            newVerifiedName[0] = verifiedNameNode.get("first_name").asText();
        } else newVerifiedName[0] = null;
        if (verifiedNameNode.has("other_name")){
            newVerifiedName[1] = verifiedNameNode.get("other_name").asText();
        } else newVerifiedName[1] = null;
        if (verifiedNameNode.has("surname")){
            newVerifiedName[2] = verifiedNameNode.get("surname").asText();
        } else newVerifiedName[2] = null;
        verifiedNameService.initVerifiedName(VerifiedName.builder().firstName(newVerifiedName[0])
                .middleName(newVerifiedName[1]).lastName(newVerifiedName[2]).build());
    }
}
