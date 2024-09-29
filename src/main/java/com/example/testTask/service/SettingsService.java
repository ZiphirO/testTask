package com.example.testTask.service;

import com.example.testTask.entities.Settings;
import com.example.testTask.repositories.SettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingsService {

    private final SettingsRepository SETTINGS_REPOSITORY;

    public Settings initSettings (Settings settings){
        return SETTINGS_REPOSITORY.save(settings);
    }
}
