package com.edu.ecafe.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.ecafe.Domain.Orderline;

public interface OrderlineRepository extends JpaRepository<Orderline, Serializable> {

}
