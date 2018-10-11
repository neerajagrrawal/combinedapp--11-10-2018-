package com.capgemini.combinedapp.controller;

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

import com.capgemini.combinedapp.entity.Product;
import com.capgemini.combinedapp.exceptions.ProductNotFoundException;
import com.capgemini.combinedapp.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		ResponseEntity<Product> responseEntity = 
				new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
		
		return responseEntity;
	}
	
	@PutMapping("/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		try {
			Product productFromDb = 
					productService.findProductById(product.getProductId());
			if(productFromDb != null)
				return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
		}
		catch(ProductNotFoundException exception) {
			//logged the exception
		}		
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> findProductById(@PathVariable int productId) {
		try {
			Product productFromDb = 
					productService.findProductById(productId);
			return new ResponseEntity<Product>(productFromDb, HttpStatus.OK);
		}
		catch(ProductNotFoundException exception) {
			//logged the exception
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int productId) {
		try {
			Product productFromDb = 
					productService.findProductById(productId);
			if(productFromDb != null) {
				productService.deleteProduct(productFromDb);
				return new ResponseEntity<Product>(HttpStatus.OK);
			}
		}
		catch(ProductNotFoundException exception) {
			//logged the exception
		}		
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/products/category/{productCategory}")
	public ResponseEntity<List<Product>> findProductByCategory(@PathVariable String productCategory) {
		try {
			List<Product> productFromDb = 
					productService.findProductByCategory(productCategory);
			return new ResponseEntity<List<Product>>(productFromDb, HttpStatus.OK);
		}
		catch(Exception exception) {
			//logged the exception
		}
		return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
	}
	
}