package com.capgemini.combinedapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.combinedapp.entity.Product;
import com.capgemini.combinedapp.exceptions.ProductNotFoundException;
import com.capgemini.combinedapp.repository.ProductRepository;
import com.capgemini.combinedapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) throws ProductNotFoundException {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent())
			return optionalProduct.get();
		throw new ProductNotFoundException("Product does not exists");
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	

	@Override
	public Product findProductByName(String productName) {
		return productRepository.findProductByName(productName) ;
	}

	@Override
	public Product findProductByCategoryAndName(String categoryName, String productName) {
		return productRepository.findProductByCategoryAndName(categoryName, productName) ;
	}

	@Override
	public Product findProductByPrice(double productPrice) {
		return productRepository.findProductByPrice(productPrice) ;
	}

	@Override
	public Product findProductByCategoryAndPrice(String productCategory, double productPrice) {
		return productRepository.findProductByCategoryAndPrice(productCategory, productPrice) ;
	}

	@Override
	public Product findProductBetweenPrice(double lowerPrice, double higherPrice) {
		return productRepository.findProductBetweenPrice(lowerPrice, higherPrice) ;
	}

	@Override
	public List<Product> findProductByCategory(String categoryName) {
		return productRepository.findProductByProductCategory(categoryName) ;
	}

}