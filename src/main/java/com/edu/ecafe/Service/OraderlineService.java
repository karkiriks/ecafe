package com.edu.ecafe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.ecafe.Domain.Orderline;
import com.edu.ecafe.Repository.OrderlineRepository;

@Service
@Transactional
public class OraderlineService {
	
	@Autowired
	OrderlineRepository orderlineRepository;
	
	public OraderlineService(){
		super();
	}
	
	public Orderline save(Orderline orderline){
		return orderlineRepository.save(orderline);
	}
	
	public void delete(Orderline orderline){
		 orderlineRepository.delete(orderline);
	}

}
