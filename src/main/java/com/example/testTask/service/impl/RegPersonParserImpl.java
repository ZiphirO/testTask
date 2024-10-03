package com.example.testTask.service.impl;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.RequestContent;
import com.example.testTask.service.RegPersonParser;
import com.example.testTask.service.RegPersonService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegPersonParserImpl implements RegPersonParser {

    private final RegPersonService regPersonService;

    @Override
    public RegPerson regPersonParse(RequestContent requestContent) {
        JsonNode regPersonNode = requestContent.getContent().get("regPerson");
        RegPerson regPerson = new RegPerson();

        if (regPersonNode.has("firstName")){
            regPerson.setFirstName(regPersonNode.get("firstName").asText());
        } else regPerson.setFirstName(null);
        if (regPersonNode.has("middleName")){
            regPerson.setMiddleName(regPersonNode.get("middleName").asText());
        } else  regPerson.setMiddleName(null);
        if (regPersonNode.has("lastName")){
            regPerson.setLastName(regPersonNode.get("lastName").asText());
        } else regPerson.setLastName(null);
        return regPersonService.initRegPerson(regPerson);
    }
}
