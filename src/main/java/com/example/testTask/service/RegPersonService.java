package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.repositories.RegPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegPersonService {

    private final RegPersonRepository REG_PERSON_REPOSITORY;

    public RegPerson initRegPerson(RegPerson regPerson){
        return REG_PERSON_REPOSITORY.save(regPerson);
    }

    public List<RegPerson> getAllRegPersons(){
        return REG_PERSON_REPOSITORY.findAll();
    }
}
