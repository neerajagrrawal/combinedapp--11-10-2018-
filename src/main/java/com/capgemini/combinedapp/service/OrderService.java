package com.capgemini.combinedapp.service;

import java.util.List;

import com.capgemini.combinedapp.entity.LineItem;
import com.capgemini.combinedapp.entity.Order;
import com.capgemini.combinedapp.exceptions.OrderNotFoundException;

public interface OrderService {
	
	public Order addOrder(Order order);

	public Order updateOrder(Order order);

	public Order findOrderById(long orderId) throws OrderNotFoundException;

	public boolean deleteOrder(long orderId);
	
	public List<Order> findAllOrders();
	
	public boolean addLineItem(LineItem lineItem,Order order) ;
	
	public void remLineItem(LineItem lineItem) ;

	public boolean cancelOrder(long orderId);
	
	public List<LineItem> findAllLineItems(long orderId) ;
}
