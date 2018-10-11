package com.capgemini.combinedapp.service;

import java.util.List;

import com.capgemini.combinedapp.entity.Customer;
import com.capgemini.combinedapp.exceptions.AuthenticationFailedException;
import com.capgemini.combinedapp.exceptions.CustomerNotFoundException;

public interface CustomerService {

	public Customer addCustomer(Customer customer) ;
	
	public Customer updateCustomer(Customer customer) ;
	
	public void deleteCustomer(Customer customer) ;
	
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException ;
	
	public List<Customer> findAllCustomer() ;
	
	public boolean authenticate(Customer customer) throws AuthenticationFailedException, CustomerNotFoundException ;
	
	public boolean updatePassword(Customer customer,String newPassword) throws AuthenticationFailedException, CustomerNotFoundException ;
}