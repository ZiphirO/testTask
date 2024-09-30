package com.example.testTask.service.impl;

import com.example.testTask.entities.Settings;
import com.example.testTask.repositories.SettingsRepository;
import com.example.testTask.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingsServiceImpl implements SettingsService {

    private final SettingsRepository settingsRepository;

    @Override
    public Settings initSettings (Settings settings){
        return settingsRepository.save(settings);
    }
}
