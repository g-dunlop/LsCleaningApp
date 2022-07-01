package com.example.cleaner;

import com.example.cleaner.models.Student;
import com.example.cleaner.models.users.Admin;
import com.example.cleaner.repositories.AdminRepository;
import com.example.cleaner.repositories.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CleanerApplicationTests {
	@Autowired
	AdminRepository adminRepository;



	private Admin admin;


	@Test
	public void contextLoads() {

	}

	@Test
	public void adminHasName(){
		Admin admin1 = new Admin(1L, "Bob", "2132134", "bob@bob", "Admin");
		adminRepository.save(admin1);
		assertEquals("Bob", admin1.getName());
	}




}
