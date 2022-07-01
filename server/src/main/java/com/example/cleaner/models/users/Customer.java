package com.example.cleaner.models.users;

import javax.persistence.*;

@Entity
@Table
public class Customer extends User {
    @Column(name="address")
    private String address;
    @Column(name="postcode")
    private String postcode;

    public Customer(Long id, String name, String phoneNumber, String email, String role, String address, String postcode) {
        super(id, name, phoneNumber, email, role);
        this.address = address;
        this.postcode = postcode;
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
