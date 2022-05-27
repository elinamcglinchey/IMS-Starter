//package com.qa.ims.persistence.domain;
//
//public class OrderItem {
//
//	private Long orderItemId;
//	private Double cost;
//	private String name;
//	private Long itemId;
//	
//	public OrderItem(Double cost, String name, Long itemId) {
//		super();
//		this.cost = cost;
//		this.name = name;
//		this.itemId = itemId;
//	}
//
//	public OrderItem(Long orderItemId, Double cost, String name, Long itemId) {
//		super();
//		this.orderItemId = orderItemId;
//		this.cost = cost;
//		this.name = name;
//		this.itemId = itemId;
//	}
//
//	public Long getOrderItemId() {
//		return orderItemId;
//	}
//
//	public void setOrderItemId(Long orderItemId) {
//		this.orderItemId = orderItemId;
//	}
//
//	public Double getCost() {
//		return cost;
//	}
//
//	public void setCost(Double cost) {
//		this.cost = cost;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Long getItemId() {
//		return itemId;
//	}
//
//	public void setItemId(Long itemId) {
//		this.itemId = itemId;
//	}
//
//	@Override
//	public String toString() {
//		return "OrderItem [orderItemId=" + orderItemId + ", cost=" + cost + ", name=" + name + ", itemId=" + itemId
//				+ "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
//		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((orderItemId == null) ? 0 : orderItemId.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		OrderItem other = (OrderItem) obj;
//		if (cost == null) {
//			if (other.cost != null)
//				return false;
//		} else if (!cost.equals(other.cost))
//			return false;
//		if (itemId == null) {
//			if (other.itemId != null)
//				return false;
//		} else if (!itemId.equals(other.itemId))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (orderItemId == null) {
//			if (other.orderItemId != null)
//				return false;
//		} else if (!orderItemId.equals(other.orderItemId))
//			return false;
//		return true;
//	}
//	
//	
//}