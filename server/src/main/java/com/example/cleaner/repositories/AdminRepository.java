package com.example.cleaner.repositories;

import com.example.cleaner.models.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
