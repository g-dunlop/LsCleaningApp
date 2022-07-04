package com.example.cleaner.models.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private String date;

    @Column(name="score")
    private double score;

    @Column(name="comment")
    private String comment;



    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cleaner_id", nullable = false)
    private Cleaner cleaner;

    @JsonIgnoreProperties({"reviews"})
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Review(String date, double score, String comment, Cleaner cleaner, Customer customer) {
        this.date = date;
        this.score = score;
        this.comment = comment;
        this.customer = customer;
        this.cleaner = cleaner;
    }

    public Review(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(Cleaner cleaner) {
        this.cleaner = cleaner;
    }
}
