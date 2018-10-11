package com.capgemini.combinedapp.controller;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.combinedapp.entity.Order;
import com.capgemini.combinedapp.exceptions.OrderNotFoundException;
import com.capgemini.combinedapp.service.OrderService;
import com.capgemini.combinedapp.service.ProductService;

@RestController
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	ProductService productService ;
	
	@PostMapping("/order")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		order.setOrderDate(LocalDate.now());
		order=orderService.addOrder(order) ;
		return new ResponseEntity<Order>(order,HttpStatus.OK) ;
	}
	
	@PutMapping("/orders/{orderId}/cancel")
	public ResponseEntity<Boolean> cancelOrder(@PathVariable long orderId)   {
		boolean check=orderService.cancelOrder(orderId) ;
		//System.out.println(check);
		if(check==true)
		return new ResponseEntity<Boolean>(check,HttpStatus.OK) ;
		else
			return new ResponseEntity<Boolean>(check,HttpStatus.NOT_FOUND) ;
		
	}
	
	@PutMapping("/order")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		order.setOrderDate(LocalDate.now());
		order=orderService.updateOrder(order) ;
		return new ResponseEntity<Order>(order,HttpStatus.OK) ;
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
		try {
			Order order = orderService.findOrderById(orderId) ;
			return new ResponseEntity<Order>(order,HttpStatus.OK) ;
		}
		catch (OrderNotFoundException e) {
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND) ;
		}
		
	}
	
	@PutMapping("/orders/{orderId}/delete")
	public ResponseEntity<Boolean> deleteOrder(@PathVariable long orderId)   {
		boolean check=orderService.deleteOrder(orderId) ;
		if(check==true)
		return new ResponseEntity<Boolean>(check,HttpStatus.OK) ;
		else
			return new ResponseEntity<Boolean>(check,HttpStatus.NOT_FOUND) ;
		
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> findAllOrders()   {
		List<Order> orders=orderService.findAllOrders() ;
		Iterator<Order> iterable= orders.iterator() ;
		if(iterable.hasNext())
		{
			return new ResponseEntity<List<Order>>(orders, HttpStatus.OK) ;
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		
	}
	
 
}
