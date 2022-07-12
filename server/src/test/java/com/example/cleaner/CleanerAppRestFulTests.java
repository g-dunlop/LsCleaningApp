package com.example.cleaner;

import com.example.cleaner.models.users.Admin;
import com.example.cleaner.repositories.AdminRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CleanerAppRestFulTests {

    @Autowired
    AdminRepository adminRepository;

    private Admin admin;

    @Test
    public void contextLoads() {
    }

    @Test
    public void canGetAdminById(){
        Admin admin1 = new Admin( "Bob", "2132134", "bob@bob", "Admin");
        adminRepository.save(admin1);
        assertEquals("Bob", adminRepository.findById(1L).get().getName());
    }

}
