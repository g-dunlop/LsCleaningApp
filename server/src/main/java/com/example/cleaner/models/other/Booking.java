package com.example.cleaner.models.other;

import com.example.cleaner.models.users.Cleaner;
import com.example.cleaner.models.users.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private LocalDate date;

    @Column(name="time")
    private LocalTime time;

    @JsonIgnoreProperties({"bookings", "reviews", "cleaner", "customer", "services"})
//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cleaner_id", nullable = false)
    private Cleaner cleaner;

    @JsonIgnoreProperties({"bookings", "reviews", "cleaner", "customer", "services"})
//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnoreProperties({"bookings"})
//    @JsonBackReference
    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Service> services;

    @Column(name="Latitude")
    private double customerLat;

    @Column(name="Longitude")
    private double customerLng;

    public Booking(LocalDate date, LocalTime time, Cleaner cleaner, Customer customer, List<Service> services, double customerLat, double customerLng) {
        this.date = date;
        this.time = time;
        this.cleaner = cleaner;
        this.customer = customer;
        this.services = services;
        this.customerLat = customerLat;
        this.customerLng = customerLng;
    }

    public Booking (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public void setCleaner(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public double getCustomerLat() {
        return customerLat;
    }

    public void setCustomerLat(double customerLat) {
        this.customerLat = customerLat;
    }

    public double getCustomerLng() {
        return customerLng;
    }

    public void setCustomerLng(double customerLng) {
        this.customerLng = customerLng;
    }
}
