package com.example.cleaner.repositories;

import com.example.cleaner.models.other.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
