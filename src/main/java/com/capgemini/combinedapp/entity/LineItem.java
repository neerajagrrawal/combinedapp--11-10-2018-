package com.capgemini.combinedapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="lineItems")
public class LineItem {
	
	
	Product product; ;
	int quantity ;
	long orderId ;
	public LineItem() {
		super();
	}
	public LineItem(Product product, int quantity, long orderId) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.orderId = orderId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
}
