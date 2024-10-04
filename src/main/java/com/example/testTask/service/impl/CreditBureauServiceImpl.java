package com.example.testTask.service.impl;

import com.example.testTask.entities.CreditBureau;
import com.example.testTask.repositories.CreditBureauRepository;
import com.example.testTask.service.CreditBureauService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditBureauServiceImpl implements CreditBureauService {

    private final CreditBureauRepository creditBureauRepository;

    @Override
    public CreditBureau initCreditBureau(CreditBureau creditBureau){
        return creditBureauRepository.save(creditBureau);
    }

}
