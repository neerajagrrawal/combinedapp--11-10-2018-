package com.capgemini.combinedapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.combinedapp.entity.LineItem;
import com.capgemini.combinedapp.entity.Order;
import com.capgemini.combinedapp.exceptions.OrderNotFoundException;
import com.capgemini.combinedapp.repository.OrderRepository;
import com.capgemini.combinedapp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
		
	}

	@Override
	public Order findOrderById(long orderId) throws OrderNotFoundException {
		Optional<Order> optionalOrder= orderRepository.findById((int) orderId) ;
		if(optionalOrder.isPresent())
			return optionalOrder.get();
		throw new OrderNotFoundException("Order does not exists");
	}
	

	@Override
	public List<Order> findAllOrders() {
		List<Order> allCustomers=(List<Order>) orderRepository.findAll() ;
		return allCustomers ;
	}

	
	
	
	@Override
	public void remLineItem(LineItem lineItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean cancelOrder(long orderId) {
		
		try {
			Order order=findOrderById(orderId);
			order.setOrderCancelledStatus(true) ;
			updateOrder(order) ;
			return true ;
		}
		 catch (OrderNotFoundException e) {
			return false ;
		}
		
	}

	@Override
	public List<LineItem> findAllLineItems(long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addLineItem(LineItem lineItem, Order order) {
		order.getCartItems().add(lineItem);
		return true;
	}

	@Override
	public boolean deleteOrder(long orderId) {
		try {
			Order order=findOrderById(orderId);
			order.setOrderDeletedStatus(true) ;
			updateOrder(order) ;
			return true ;
		}
		 catch (OrderNotFoundException e) {
			return false ;
		}
	}

	

	

}
