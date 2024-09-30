package com.example.testTask.service.impl;

import com.example.testTask.entities.Settings;
import com.example.testTask.repositories.SettingsRepository;
import com.example.testTask.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingsServiceImpl implements SettingsService {

    private final SettingsRepository SETTINGS_REPOSITORY;

    @Override
    public Settings initSettings (Settings settings){
        return SETTINGS_REPOSITORY.save(settings);
    }
}
