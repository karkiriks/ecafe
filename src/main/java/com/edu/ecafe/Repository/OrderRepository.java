package com.edu.ecafe.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.ecafe.Domain.Order;

public interface OrderRepository extends JpaRepository<Order, Serializable>{

	public List<Order> findAll();

}
