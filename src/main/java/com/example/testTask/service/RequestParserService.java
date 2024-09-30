package com.example.testTask.service;

import com.example.testTask.entities.RequestContent;

public interface RequestParserService {

    void parseRequest(RequestContent requestContent) throws NullPointerException;
}
