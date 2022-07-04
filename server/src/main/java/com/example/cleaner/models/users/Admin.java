package com.example.cleaner.models.users;

import javax.persistence.*;

@Entity
@Table(name="admins")
public class Admin extends User {

    public Admin( String name, String phoneNumber, String email, String role) {
        super( name, phoneNumber, email, role);
    }

    public Admin() {
    }


}
