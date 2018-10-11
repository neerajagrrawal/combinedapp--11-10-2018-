package com.capgemini.combinedapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.combinedapp.entity.Customer;
import com.capgemini.combinedapp.exceptions.AuthenticationFailedException;
import com.capgemini.combinedapp.exceptions.CustomerNotFoundException;
import com.capgemini.combinedapp.repository.CustomerRepository;
import com.capgemini.combinedapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository ;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer) ;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer) ;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);

	}

	@Override
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId) ;
		if(optionalCustomer.isPresent())
			return optionalCustomer.get();
		throw new CustomerNotFoundException("Customer does not exists");
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> allCustomers=customerRepository.findAll() ;
		return allCustomers ;
	}

	

	@Override
	public boolean authenticate(Customer customer) throws AuthenticationFailedException, CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById((int) customer.getCustomerId()) ;
		int check=-1 ;
		if(optionalCustomer.isPresent())
		{
			check= customerRepository.authenticate(customer.getCustomerPassword()) ;
			if(check!=-1)
				return true ;
			throw new AuthenticationFailedException("Invalid Password") ;
		}
		throw new CustomerNotFoundException("Customer does not exists");

	}

	@Override
	public boolean updatePassword(Customer customer,String newPassword) throws AuthenticationFailedException, CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById((int) customer.getCustomerId()) ;
		int check =-1;
		if(optionalCustomer.isPresent())
		{
			check= customerRepository.authenticate(customer.getCustomerPassword()) ;
			if(check!=-1)
			{
				customerRepository.save(customer) ;
				return true ;
			}
				
			throw new AuthenticationFailedException("Invalid Password") ;
		}
		throw new CustomerNotFoundException("Customer does not exists");
	}


}