package com.example.testTask.service.impl;

import com.example.testTask.entities.StopFactor;
import com.example.testTask.repositories.StopFactorRepository;
import com.example.testTask.service.StopFactorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StopFactorImpl implements StopFactorService {

    private final StopFactorRepository stopFactorRepository;

    @Override
    public StopFactor initStopFactor(StopFactor stopFactor) {
        return stopFactorRepository.save(stopFactor);
    }
}
