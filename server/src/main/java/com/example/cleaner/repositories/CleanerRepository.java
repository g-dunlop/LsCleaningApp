package com.example.cleaner.repositories;

import com.example.cleaner.models.users.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanerRepository extends JpaRepository<Cleaner, Integer> {
}
