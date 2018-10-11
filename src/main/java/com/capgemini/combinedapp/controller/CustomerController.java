package com.capgemini.combinedapp.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.combinedapp.entity.Customer;
import com.capgemini.combinedapp.exceptions.CustomerNotFoundException;
import com.capgemini.combinedapp.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService ;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		ResponseEntity<Customer> responseEntity=new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.OK) ;
		return responseEntity ;
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable int customerId)
	{
		try {
			ResponseEntity<Customer> responseEntity=new ResponseEntity<Customer>(customerService.findCustomerById(customerId),HttpStatus.OK) ;
			return responseEntity ;
		} catch (CustomerNotFoundException e) {
			// log errors
		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND) ;
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		try {
			Customer customer1=customerService.findCustomerById(customer.getCustomerId()) ;
			customer1=customerService.updateCustomer(customer) ;
			return new ResponseEntity<Customer>(customer1,HttpStatus.OK) ;
		}
		catch (CustomerNotFoundException e) {
			// log
		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND) ;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId)
	{
		try {
			Customer customer=customerService.findCustomerById(customerId) ;
			customerService.deleteCustomer(customer);
		}
		catch (CustomerNotFoundException e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND) ;
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> findAllCustomer()
	{
		List<Customer> customers=customerService.findAllCustomer() ;
		Iterator<Customer> iterable= customers.iterator() ;
		if(iterable.hasNext())
		{
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK) ;
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		
	}
	
	@GetMapping("/authenticate/{customerId}/{password}")
	public ResponseEntity<Boolean> authenticate(@PathVariable int customerId,@PathVariable String password)
	{
		Customer cust=new Customer() ;
		cust.setCustomerId(customerId);
		cust.setCustomerPassword(password);
		Boolean ans ;
		try {
		ans=customerService.authenticate(cust) ;

		return new ResponseEntity<Boolean>(ans,HttpStatus.OK) ;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		ans=false ;
		return new ResponseEntity<Boolean>(ans,HttpStatus.OK) ;
}
}