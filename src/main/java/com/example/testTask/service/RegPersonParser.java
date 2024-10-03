package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.RequestContent;

public interface RegPersonParser {

    RegPerson regPersonParse(RequestContent requestContent);
}
