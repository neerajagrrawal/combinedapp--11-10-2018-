package com.capgemini.combinedapp.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="orders")
public class Order {

	@Id
	long orderId ;
	double orderTotal ;
	LocalDate orderDate ;
	long customerId ;
	boolean OrderCancelledStatus ;
	boolean OrderDeletedStatus ;
	List<LineItem> cartItems ;
	String orderStatus ;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long orderId, double orderTotal, LocalDate orderDate, long customerId, boolean orderCancelledStatus,
			boolean orderDeletedStatus, List<LineItem> cartItems, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderTotal = orderTotal;
		this.orderDate = orderDate;
		this.customerId = customerId;
		OrderCancelledStatus = orderCancelledStatus;
		OrderDeletedStatus = orderDeletedStatus;
		this.cartItems = cartItems;
		this.orderStatus = orderStatus;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public boolean isOrderCancelledStatus() {
		return OrderCancelledStatus;
	}
	public void setOrderCancelledStatus(boolean orderCancelledStatus) {
		OrderCancelledStatus = orderCancelledStatus;
	}
	public boolean isOrderDeletedStatus() {
		return OrderDeletedStatus;
	}
	public void setOrderDeletedStatus(boolean orderDeletedStatus) {
		OrderDeletedStatus = orderDeletedStatus;
	}
	public List<LineItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<LineItem> cartItems) {
		this.cartItems = cartItems;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	

	
	
	
}
