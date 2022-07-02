package com.example.cleaner.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cleaners")
public class Cleaner extends User {

    @Column(name="rating")
    private double rating;


    @OneToMany(mappedBy = "cleaner", fetch = FetchType.LAZY)
    private List<Review> reviews;

    public Cleaner(Long id, String name, String phoneNumber, String email, String role, double rating) {
        super(id, name, phoneNumber, email, role);
        this.rating = rating;
        this.reviews = new ArrayList<>();
    }

    public Cleaner() {

    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }
}

