package com.example.cleaner.repositories;

import com.example.cleaner.models.other.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
