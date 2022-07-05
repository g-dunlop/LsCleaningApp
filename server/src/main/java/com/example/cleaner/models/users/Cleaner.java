package com.example.cleaner.models.users;

import com.example.cleaner.models.other.Booking;
import com.example.cleaner.models.other.Review;
import com.example.cleaner.models.other.Service;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cleaners")
public class Cleaner extends User {

    @Column(name="rating")
    private double rating;

    @JsonIgnoreProperties({"cleaner"})
    @OneToMany(mappedBy = "cleaner", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JsonIgnoreProperties({"cleaners"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name="cleaners_services",
            joinColumns = {@JoinColumn(name = "cleaner_id", nullable=true, updatable=false)},
            inverseJoinColumns = {@JoinColumn(name="service_id", nullable=true, updatable=false)}
    )
    private List<Service> services;

    @JsonIgnoreProperties({"cleaner"})
    @OneToMany(mappedBy = "cleaner", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Cleaner( String name, String phoneNumber, String email, String role, double rating) {
        super( name, phoneNumber, email, role);
        this.rating = rating;
        this.reviews = new ArrayList<>();
        this.services = new ArrayList<>();
        this.bookings = new ArrayList<>();
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void addService(Service service){
        this.services.add(service);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}

