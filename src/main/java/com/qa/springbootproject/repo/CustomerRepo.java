package com.qa.springbootproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springbootproject.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
