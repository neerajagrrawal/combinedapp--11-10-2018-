package com.capgemini.combinedapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.combinedapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT customerId FROM Customer WHERE password = :password")
	public int authenticate(@Param("password") String password) ;
	
}