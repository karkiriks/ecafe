package com.edu.ecafe.Domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order {

	@Id @GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	private int quantity;
	private int totalAmount;
	@OneToMany(mappedBy="orders")
	private List<Orderline> orderList;
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<Orderline> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Orderline> orderList) {
		this.orderList = orderList;
	}
	
	
	
}
