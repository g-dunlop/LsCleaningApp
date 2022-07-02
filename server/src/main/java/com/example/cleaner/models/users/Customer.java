package com.example.cleaner.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer extends User {
    @Column(name="address")
    private String address;
    @Column(name="postcode")
    private String postcode;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Review> reviews;


    public Customer(Long id, String name, String phoneNumber, String email, String role, String address, String postcode) {
        super(id, name, phoneNumber, email, role);
        this.address = address;
        this.postcode = postcode;
        this.reviews = new ArrayList<>();

    }

    public Customer(){

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
