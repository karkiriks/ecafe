package com.edu.ecafe.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.ecafe.Domain.Product;

public interface ProductRepository  extends JpaRepository<Product, Serializable>{

}
