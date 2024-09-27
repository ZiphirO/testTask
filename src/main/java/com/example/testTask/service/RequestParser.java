package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.RequestContent;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.repositories.RequestContentRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestParser {

    @Autowired
    private RequestContentRepository requestContentRepository;
    @Autowired
    private RegPersonService regPersonService;
    @Autowired
    private VerifiedNameService verifiedNameService;

    public void parseRequest(RequestContent requestContent) {
        JsonNode content = requestContent.getContent();
        regPersonService.initRegPerson(RegPerson.builder().firstName(content.get("regPerson").get("firstName").asText())
                .middleName(content.get("regPerson").get("middleName").asText())
                .lastName(content.get("regPerson").get("lastName").asText()).build());

        verifiedNameService.initVerifiedName(VerifiedName.builder().firstName(content.get("verifiedName").get("firstName").asText())
                .middleName(content.get("verifiedName").get("middleName").asText())
                .lastName(content.get("verifiedName").get("lastName").asText()).build());
    }
}
