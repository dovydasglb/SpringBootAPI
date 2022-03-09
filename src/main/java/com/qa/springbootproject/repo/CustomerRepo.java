package com.qa.springbootproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springbootproject.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	// Custom queries
	@Query(value = "SELECT * from customer WHERE first_name = ?1", nativeQuery = true)
	List<Customer> readAllByFirstName(String firstName);

	@Query(value = "SELECT * from customer WHERE last_name = ?1", nativeQuery = true)
	List<Customer> readAllByLastName(String lastName);
}
