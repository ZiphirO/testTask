package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.repositories.RegPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegPersonService {

    @Autowired
    private RegPersonRepository regPersonRepository;

    public RegPerson initRegPerson(RegPerson regPerson){
        return regPersonRepository.save(regPerson);
    }

    public List<RegPerson> getAllRegPersons(){
        return regPersonRepository.findAll();
    }
}
