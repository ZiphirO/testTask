package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;

import java.util.List;

public interface RegPersonService {

    RegPerson initRegPerson(RegPerson regPerson);
    List<RegPerson> getAllRegPersons();
}
