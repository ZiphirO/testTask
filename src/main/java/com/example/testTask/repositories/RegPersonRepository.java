package com.example.testTask.repositories;

import com.example.testTask.entities.RegPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegPersonRepository extends JpaRepository<RegPerson, Long> {
}
