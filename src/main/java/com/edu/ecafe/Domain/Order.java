package com.edu.ecafe.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy="order",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Orderline> orderLines;
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		int quantity=0;
		for (Orderline ol : this.orderLines)
		{
			quantity+=ol.getQuantity();
		}
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalAmount() {
		int totalAmount=0;
		for (Orderline ol : this.orderLines)
		{
			totalAmount += ol.getSubtotal();
		}
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<Orderline> getOrderLine() {
		return orderLines;
	}
	public void setOrderLine(List<Orderline> orderLine) {
		this.orderLines = orderLine;
	}
	
	public void addOrderLine(Orderline ol){
		if (this.orderLines == null){
			this.orderLines = new ArrayList<Orderline>();
		}
		this.orderLines.add(ol);
		this.quantity += ol.getQuantity();
		this.totalAmount+=ol.getSubtotal();
	}
	
}
