package com.example.cleaner.repositories;

import com.example.cleaner.models.other.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
