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

import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private CustomerController controller;

	@Test
	public void testCreate() {
		//final String ITEM_ID = "4", ITEM_COST = "0.65", ITEM_NAME = "pencil";
		final Long ITEM_ID = 1L;
		final Double ITEM_COST = 0.65;
		final String ITEM_NAME = "pencil";
		final Item created = new Item(ITEM_ID, ITEM_COST, ITEM_NAME);
		
		//final String F_NAME = "barry", L_NAME = "scott", U_NAME = "scottyb123", P_WORD = "scottpass123";
		//final Customer created = new Customer(F_NAME, L_NAME, U_NAME, P_WORD);

		
		Mockito.when(utils.getLong()).thenReturn(ITEM_ID);
		Mockito.when(utils.getDouble()).thenReturn(ITEM_COST);
		Mockito.when(utils.getString()).thenReturn(ITEM_NAME);
		//Mockito.when(utils.getString()).thenReturn(ITEM_ID, ITEM_COST, ITEM_NAME);
		// Mockito.when(utils.getString()).thenReturn(ITEM_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(2L,0.35, "rubber"));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item(1L, 5.99, "calculator");

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getDouble()).thenReturn(5.99);
		Mockito.when(this.utils.getString()).thenReturn(updated.getName());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update()); 

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
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
