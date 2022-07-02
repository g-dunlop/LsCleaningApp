package com.example.cleaner;

import com.example.cleaner.models.users.Admin;
import com.example.cleaner.models.users.Cleaner;
import com.example.cleaner.models.users.Customer;
import com.example.cleaner.models.other.Service;
import com.example.cleaner.models.users.Review;
import com.example.cleaner.repositories.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CleanerApplicationTests {
	@Autowired
	AdminRepository adminRepository;

	@Autowired
	CleanerRepository cleanerRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	ReviewRepository reviewRepository;


	private Admin admin;
	private Cleaner cleaner;
	private Customer customer;
	private Service service;
	private Review review;

	@Test
	public void contextLoads() {
	}

	@Test
	public void adminHasAttributes() {
		Admin admin1 = new Admin(1L, "Bob", "2132134", "bob@bob", "Admin");
		adminRepository.save(admin1);
		assertEquals("Bob", admin1.getName());
		assertEquals("2132134", admin1.getPhoneNumber());
		assertEquals("bob@bob", admin1.getEmail());
		assertEquals("Admin", admin1.getRole());
	}

	@Test
	public void canFindAllAdmins() {
		Admin admin1 = new Admin(1L, "Bob", "2132134", "bob@bob", "Admin");
		adminRepository.save(admin1);
		List<Admin> admins = adminRepository.findAll();
		assertEquals(1, admins.size());
	}

	@Test
	public void cleanerHasAttributes() {
		Cleaner cleaner1 = new Cleaner(1L, "Bill", "342432", "bill@bill", "Cleaner", 4.5);
		cleanerRepository.save(cleaner1);
		assertEquals("Bill", cleaner1.getName());
		assertEquals("342432", cleaner1.getPhoneNumber());
		assertEquals("bill@bill", cleaner1.getEmail());
		assertEquals("Cleaner", cleaner1.getRole());
		assertEquals(4.5, cleaner1.getRating());
	}

	@Test
	public void canFindAllCleaners() {
		Cleaner cleaner1 = new Cleaner(1L, "Bill", "342432", "bill@bill", "Cleaner", 4.5);
		cleanerRepository.save(cleaner1);
		List<Cleaner> cleaners = cleanerRepository.findAll();
		assertEquals(1, cleaners.size());
	}

	@Test
	public void customerHasAttributes() {
		Customer customer = new Customer(1L, "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
		customerRepository.save(customer);
		assertEquals("Robert", customer.getName());
		assertEquals("767676", customer.getPhoneNumber());
		assertEquals("rob@robert", customer.getEmail());
		assertEquals("Customer", customer.getRole());
		assertEquals("17 The Lane", customer.getAddress());
		assertEquals("FK54XE", customer.getPostcode());
	}

	@Test
	public void canFindAllCustomers() {
		Customer customer = new Customer(1L, "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
		customerRepository.save(customer);
		List<Customer> customers = customerRepository.findAll();
		assertEquals(1, customers.size());
	}

	@Test
	public void serviceHasAttributes() {
		Service service = new Service( "Domestic clean - 2 Hrs", "Mop, bucket, spade", new BigDecimal("50.50"));
		serviceRepository.save(service);
		assertEquals("Domestic clean - 2 Hrs", service.getName());
		assertEquals("Mop, bucket, spade", service.getEquipment());
		assertEquals( new BigDecimal("50.50"), service.getPrice());
	}


	@Test
	public void canFindAllServices(){
		Service service = new Service( "Domestic clean - 2 Hrs", "Mop, bucket, spade", new BigDecimal("50.50"));
		serviceRepository.save(service);
		List<Service> services =  serviceRepository.findAll();
		assertEquals(1, services.size());
	}

	@Test
	public void reviewExists(){
		Customer customer = new Customer(1L, "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
		customerRepository.save(customer);
		Review review = new Review("15/07/2022",3.6, "pretty shit", customer);
		reviewRepository.save(review);
		assertEquals(3.6, review.getScore());
	}
}