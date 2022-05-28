package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long customerId;
	private Double cost;
	public Order(Long customerId, Double cost) {
		super();
		this.customerId = customerId;
		this.cost = cost;
	}
	
		
	public Order(Long orderId, Long customerId, Double cost) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.cost = cost;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", cost=" + cost + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
	
	
}