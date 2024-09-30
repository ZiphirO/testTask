package com.example.testTask.service;

import com.example.testTask.entities.RequestContent;

import java.io.IOException;
import java.util.List;

public interface RequestContentService {

    RequestContent createRequestContent(RequestContent requestContent);
    List<RequestContent> fetchPersonsInfo() throws IOException;
}
