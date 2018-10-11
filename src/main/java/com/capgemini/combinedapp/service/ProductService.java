package com.capgemini.combinedapp.service;

import java.util.List;

import com.capgemini.combinedapp.entity.Product;
import com.capgemini.combinedapp.exceptions.ProductNotFoundException;

public interface ProductService {

	public Product addProduct(Product product);

	public Product updateProduct(Product product);

	public Product findProductById(int productId) throws ProductNotFoundException;

	public void deleteProduct(Product product);
	
	public List<Product> findProductByCategory(String categoryName) ;
	
	public Product findProductByName(String productName) ;
	
	public Product findProductByCategoryAndName(String categoryName,String productName) ;
	
	public Product findProductByPrice(double productPrice);
	
	public Product findProductByCategoryAndPrice(String productCategory,double productPrice) ;
	
	public Product findProductBetweenPrice(double lowerPrice,double higherPrice) ;

}
