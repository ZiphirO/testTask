package com.example.testTask.service.impl;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.repositories.RegPersonRepository;
import com.example.testTask.service.RegPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegPersonServiceImpl implements RegPersonService {

    private final RegPersonRepository REG_PERSON_REPOSITORY;

    @Override
    public RegPerson initRegPerson(RegPerson regPerson){
        return REG_PERSON_REPOSITORY.save(regPerson);
    }

    @Override
    public List<RegPerson> getAllRegPersons(){
        return REG_PERSON_REPOSITORY.findAll();
    }
}
