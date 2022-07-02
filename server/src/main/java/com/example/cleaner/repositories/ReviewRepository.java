package com.example.cleaner.repositories;

import com.example.cleaner.models.users.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
