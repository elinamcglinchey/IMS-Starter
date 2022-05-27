package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.qa.ims.controller.OrderController;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		//final String ITEM_ID = "4", ITEM_COST = "0.65", ITEM_NAME = "pencil";
		//final Long ORDERITEM_ID = 189L;
		final Long ORDER_ID = 9L;
		final Long CUSTOMER_ID = 190L;
		final Double COST = 77.05;
		final Order created = new Order(ORDER_ID, CUSTOMER_ID, COST);

	Mockito.when(utils.getLong()).thenReturn(ORDER_ID, CUSTOMER_ID);
		//Mockito.when(utils.getLong()).thenReturn(CUSTOMER_ID);
		Mockito.when(utils.getDouble()).thenReturn(COST);
		//Mockito.when(utils.getString()).thenReturn(ITEM_ID, ITEM_COST, ITEM_NAME);
		// Mockito.when(utils.getString()).thenReturn(ITEM_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	
	}

	@Test
	public void testReadAll() { // add to sql data
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(12L, 1231L, 88.90));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(13L, 190L, 77.05);

		Mockito.when(this.utils.getLong()).thenReturn(updated.getOrderId(),updated.getCustomerId());
	//	Mockito.when(this.utils.getLong()).thenReturn(190L);
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getCost());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		// Test to see if total items in order work
//		System.out.println(updated);
//		System.out.println(this.controller.update());
		// latest and most updated version input
		assertEquals(updated, this.controller.update()); 

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).update(updated);
	}

	@Test 
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}