package com.edu.ecafe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.edu.ecafe.Domain.Product;
import com.edu.ecafe.Domain.ProductType;
import com.edu.ecafe.Repository.ProductRepository;

@Service
@Transactional
public class ProductService   {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	public ProductService( ) {
		super();
	}
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ProductRepository getProductRepository() {
		
		return productRepository;
	}
	
	public void update(String productName, String description, double price , ProductType productType , int id) {
		 productRepository.setProductById(productName, description, price, productType, id);
	}	
	
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

	public Product getProduct(int productId) {
		return (Product) productRepository.findOne(productId);
	}

	public List<Product> getAllProduct() {
		return  productRepository.findAll() ;
	}
	
	public List<Product> findByProductNameOrDescriptionIgnoreCase(String productName, String description) {
		 return productRepository.findByProductNameOrDescriptionIgnoreCase(productName, description);
	}

	public List<Product> findByPrice(double price) {
		return  productRepository.findByPrice(price);
	}
	
	public List<Product> findByProductType(ProductType productType) {
		 return productRepository.findByProductType(productType);
	}
	
	public Product findById(int id){
		return productRepository.findById(id);
	}
}
