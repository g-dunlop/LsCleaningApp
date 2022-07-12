package com.example.cleaner;

import com.example.cleaner.models.other.Booking;
import com.example.cleaner.models.users.Admin;
import com.example.cleaner.models.users.Cleaner;
import com.example.cleaner.models.users.Customer;
import com.example.cleaner.models.other.Service;
import com.example.cleaner.models.other.Review;
import com.example.cleaner.repositories.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

	@Autowired
	BookingRepository bookingRepository;


	private Admin admin;
	private Cleaner cleaner;
	private Customer customer;
	private Service service;
	private Review review;

	private Booking booking;



	@Test
	public void contextLoads() {
	}

	@Test
	public void adminHasAttributes() {
		Admin admin1 = new Admin( "Bob", "2132134", "bob@bob", "Admin");
		adminRepository.save(admin1);
		assertEquals("Bob", admin1.getName());
		assertEquals("2132134", admin1.getPhoneNumber());
		assertEquals("bob@bob", admin1.getEmail());
		assertEquals("Admin", admin1.getRole());
	}

	@Test
	public void canFindAllAdmins() {
		Admin admin1 = new Admin( "Bob", "2132134", "bob@bob", "Admin");
		adminRepository.save(admin1);
		List<Admin> admins = adminRepository.findAll();
		assertEquals(1, admins.size());
	}

	@Test
	public void cleanerHasAttributes() {
		Cleaner cleaner1 = new Cleaner( "Bill", "342432", "bill@bill", "Cleaner", 4.5);
		cleanerRepository.save(cleaner1);
		assertEquals("Bill", cleaner1.getName());
		assertEquals("342432", cleaner1.getPhoneNumber());
		assertEquals("bill@bill", cleaner1.getEmail());
		assertEquals("Cleaner", cleaner1.getRole());
		assertEquals(4.5, cleaner1.getRating());
	}

	@Test
	public void canFindAllCleaners() {
		Cleaner cleaner1 = new Cleaner( "Bill", "342432", "bill@bill", "Cleaner", 4.5);
		cleanerRepository.save(cleaner1);
		List<Cleaner> cleaners = cleanerRepository.findAll();
		assertEquals(1, cleaners.size());
	}

	@Test
	public void customerHasAttributes() {
		Customer customer = new Customer( "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
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
		Customer customer = new Customer( "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
		customerRepository.save(customer);
		List<Customer> customers = customerRepository.findAll();
		assertEquals(1, customers.size());
	}

	@Test
	public void serviceHasAttributes() {
		BigDecimal price = new BigDecimal("50.50");
		Service service = new Service( "Domestic clean - 2 Hrs", "Mop, bucket, spade", price );
		serviceRepository.save(service);
		assertEquals("Domestic clean - 2 Hrs", service.getName());
		assertEquals("Mop, bucket, spade", service.getEquipment());
		assertEquals( new BigDecimal("50.50"), service.getPrice());
	}


	@Test
	public void canFindAllServices(){
		BigDecimal price = new BigDecimal("50.50");
		Service service = new Service( "Domestic clean - 2 Hrs", "Mop, bucket, spade", price );
		serviceRepository.save(service);
		List<Service> services =  serviceRepository.findAll();
		assertEquals(1, services.size());
	}

	@Test
	public void reviewExists(){
		Customer customer = new Customer( "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
		customerRepository.save(customer);
		Cleaner cleaner1 = new Cleaner( "Bill", "342432", "bill@bill", "Cleaner", 4.5);
		cleanerRepository.save(cleaner1);
		Review review = new Review("15/07/2022",3.6, "pretty shit", cleaner1, customer);
		reviewRepository.save(review);
//		assertEquals(3.6, review.getScore());
//		assertEquals(cleaner1, review.getCleaner());
//		assertEquals(customer, review.getCustomer());
//		assertEquals(2, review.getCleaner().getId());
//		assertEquals(2, review.getCustomer().getId());
		List<Review> reviews = reviewRepository.findAll();
		System.out.println(reviews);
//		assertEquals(1, reviews.size() );
	}

//	@Test
//	public void canAddReview(){
//		Customer customer = new Customer( "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
//		customerRepository.save(customer);
//		Cleaner cleaner1 = new Cleaner( "Bill", "342432", "bill@bill", "Cleaner", 4.5);
//		cleanerRepository.save(cleaner1);
//		Review review = new Review("15/07/2022",3.6, "pretty shit", cleaner1, customer);
//		reviewRepository.save(review);
//		List<Review> reviews = reviewRepository.findAll();
//		assertEquals(1, reviews.size() );
//	}

	@Test
	public void canAddServiceToBooking(){
		List<Service> services = new ArrayList<>();
		List<Cleaner> cleaners = new ArrayList<>();
		Customer customer = new Customer( "Robert", "767676", "rob@robert", "Customer", "17 The Lane", "FK54XE");
		customerRepository.save(customer);
		Cleaner cleaner1 = new Cleaner( "Bill", "342432", "bill@bill", "Cleaner", 4.5);
		cleanerRepository.save(cleaner1);
		BigDecimal price = new BigDecimal("50.50");
		Service service = new Service( "Domestic clean - 2 Hrs", "Mop, bucket, spade", price );
		serviceRepository.save(service);
		LocalDate date = LocalDate.parse("2020-01-08");
		LocalTime time = LocalTime.parse("00:00:00");

		Booking booking = new Booking(date, time, cleaner1, customer, services, 56.037247, -3.819953 );
		bookingRepository.save(booking);
		booking.addService(service);
		bookingRepository.save(booking);
		assertEquals("50.50", booking.getServices().get(0).getPrice());
		service.addCleaner(cleaner1);
		serviceRepository.save(service);
		assertEquals(cleaner1, service.getCleaners().get(0));
		cleaner1.addService(service);
		cleanerRepository.save(cleaner1);
		assertEquals(service, cleaner1.getServices().get(0));
	}
}