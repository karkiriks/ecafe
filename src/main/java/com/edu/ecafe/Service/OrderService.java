package com.edu.ecafe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.ecafe.Domain.Order;
import com.edu.ecafe.Repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public OrderService() {
		super();
	}
	
	public Order save(Order order){
		return orderRepository.save(order);
	}
	
	public void delete(Order order){
		orderRepository.delete(order);
	}
	
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}

}
