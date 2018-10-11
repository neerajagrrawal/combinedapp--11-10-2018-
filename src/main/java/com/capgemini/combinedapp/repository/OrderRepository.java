package com.capgemini.combinedapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.combinedapp.entity.Order;
import com.capgemini.combinedapp.entity.Product;

public interface OrderRepository extends MongoRepository<Order, Integer> {

		
	
	
}
