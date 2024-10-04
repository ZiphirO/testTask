package com.example.testTask.service.impl;

import com.example.testTask.entities.VerifiedName;
import com.example.testTask.repositories.VerifiedNameRepository;
import com.example.testTask.service.VerifiedNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VerifiedNameServiceImpl implements VerifiedNameService {

    private final VerifiedNameRepository verifiedNameRepository;

    @Override
    public VerifiedName initVerifiedName(VerifiedName verifiedName){
        return verifiedNameRepository.save(verifiedName);
    }

    @Override
    public List<VerifiedName> getAllVerifiedNames(){
        return verifiedNameRepository.findAll();
    }

    @Override
    public List<String> getVerifiedNameFields(VerifiedName verifiedName) {
        List<String> result = new ArrayList<>();
        if (verifiedName.getFirstName() != null){
            result.add(verifiedName.getFirstName());
        }
        if (verifiedName.getOtherName() != null){
            result.add(verifiedName.getOtherName());
        }
        if (verifiedName.getSurname() != null){
            result.add(verifiedName.getSurname());
        }
        return result;
    }

    @Override
    public String verifiedNameString(VerifiedName verifiedName) {
        return verifiedName.getFirstName() + verifiedName.getOtherName() + verifiedName.getSurname();
    }
}
