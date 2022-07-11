package com.example.cleaner.models.other;

import com.example.cleaner.models.users.Cleaner;
import com.example.cleaner.models.users.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="equipment")
    private String equipment;

    @Column(name="price")
    private BigDecimal price;

    @JsonIgnoreProperties({"services"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name="cleaners_services",
            joinColumns = {@JoinColumn(name = "service_id", nullable=true, updatable=false)},
            inverseJoinColumns = {@JoinColumn(name="cleaner_id", nullable=true, updatable=false)}
    )
    private List<Cleaner> cleaners;

    @JsonIgnoreProperties({"services"})
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = true)
    private Booking booking;

    public Service( String name, String equipment, BigDecimal price) {
        this.name = name;
        this.equipment = equipment;
        this.price = price;
        this.cleaners = new ArrayList<>();
        this.booking = booking;
    }

    public Service(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Cleaner> getCleaners() {
        return cleaners;
    }

    public void setCleaners(List<Cleaner> cleaners) {
        this.cleaners = cleaners;
    }

    public void addCleaner(Cleaner cleaner){
        this.cleaners.add(cleaner);
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
