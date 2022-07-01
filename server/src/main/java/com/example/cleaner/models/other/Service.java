package com.example.cleaner.models.other;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
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

    public Service( String name, String equipment, BigDecimal price) {
        this.name = name;
        this.equipment = equipment;
        this.price = price;
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
}
