package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	
	int addProduct(Product prod);
	
	int updateProduct(Product prod);
	
	
	
	List<Product> searchProduct(int sid);
	
	List<Product> getAllProducts();
	
	
	Product getProductById(int productId);

}
