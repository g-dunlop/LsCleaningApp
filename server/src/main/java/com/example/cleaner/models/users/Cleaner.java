package com.example.cleaner.models.users;

import javax.persistence.*;

@Entity
@Table(name="cleaners")
public class Cleaner extends User {

    @Column(name="rating")
    private double rating;

    public Cleaner(Long id, String name, String phoneNumber, String email, String role, double rating) {
        super(id, name, phoneNumber, email, role);
        this.rating = rating;
    }

    public Cleaner() {

    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

