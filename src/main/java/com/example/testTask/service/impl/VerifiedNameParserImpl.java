package com.example.testTask.service.impl;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.RequestContent;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.VerifiedNameParser;
import com.example.testTask.service.VerifiedNameService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifiedNameParserImpl implements VerifiedNameParser {

    private final VerifiedNameService verifiedNameService;

    @Override
    public void verifiedNameParse(RequestContent requestContent, RegPerson regPerson) {
        JsonNode verifiedNameNode = requestContent.getContent().get("creditBureau").get("verified_name");
        VerifiedName verifiedName = new VerifiedName();

        if (verifiedNameNode.has("first_name")){
            verifiedName.setFirstName(verifiedNameNode.get("first_name").asText());
        } else verifiedName.setFirstName(null);
        if (verifiedNameNode.has("other_name")){
            verifiedName.setOtherName(verifiedNameNode.get("other_name").asText());
        } else verifiedName.setOtherName(null);
        if (verifiedNameNode.has("surname")){
            verifiedName.setOtherName(verifiedNameNode.get("surname").asText());
        } else verifiedName.setOtherName(null);
        verifiedName.setRegPerson(regPerson);
        verifiedNameService.initVerifiedName(verifiedName);
    }
}
