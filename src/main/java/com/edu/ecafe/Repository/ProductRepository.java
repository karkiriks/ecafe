package com.edu.ecafe.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.ecafe.Domain.Product;
import com.edu.ecafe.Domain.ProductType;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Serializable>{

	@Modifying
	@Query("update Product u set u.productName = ?1, u.description = ?2 , u.price=?3 ,u.productType=?4  where u.id = ?5")
	public void setProductById(String productName, String description, double price , ProductType productType , int id);
	public List<Product> findByProductNameOrDescriptionIgnoreCase(String productName, String description); 
	public List<Product> findByProductType(ProductType productType); 
	public List<Product> findByPrice(double price);
	public Product findById(int id);
}
