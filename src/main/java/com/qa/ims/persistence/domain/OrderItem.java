package com.qa.ims.persistence.domain;

public class OrderItem {

	private int orderItemId;
	private float cost;
	private String name;
	private int itemId;
	
	public OrderItem(float cost, String name, int itemId) {
		super();
		this.cost = cost;
		this.name = name;
		this.itemId = itemId;
	}
	public OrderItem(int orderItemId, float cost, String name, int itemId) {
		super();
		this.orderItemId = orderItemId;
		this.cost = cost;
		this.name = name;
		this.itemId = itemId;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", cost=" + cost + ", name=" + name + ", itemId=" + itemId
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + itemId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + orderItemId;
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
		OrderItem other = (OrderItem) obj;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (itemId != other.itemId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderItemId != other.orderItemId)
			return false;
		return true;
	}
	
	
}
