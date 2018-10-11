package com.capgemini.combinedapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capgemini.combinedapp.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

	@Query("{ 'productCategory' : ?0 }")
	List<Product> findProductByProductCategory(String categoryName);
	
	@Query("{ 'productName' : ?0 }")
	public Product findProductByName(String productName) ;
	
	
	@Query("{'$and':[ {'productCategory':?0}, {'productName':?1} ] }")
	public Product findProductByCategoryAndName(String categoryName,String productName) ;
	
	@Query("{ 'productPrice' : ?0 }")
	public Product findProductByPrice(double productPrice);
	
	@Query("{'$and':[ {'productCategory':?0}, {'productPrice':?1} ] }")
	public Product findProductByCategoryAndPrice(String productCategory,double productPrice) ;
	
	@Query("{'productPrice' : {$gt : ?0, $lt : ?1}}")
	public Product findProductBetweenPrice(double lowerPrice,double higherPrice) ;

}