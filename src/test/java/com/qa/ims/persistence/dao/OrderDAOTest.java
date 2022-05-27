package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Before
	public void insert() {
		final Order created1= new Order(1L, 188L, 11.13);
		//final Order created2 = new Customer (2L, 2L);
		DAO.create(created1);
		//DAO.create(created2);
		// Data didn't appear as I wanted to in schema, implemented data inside the test
		// now using Anna instead of Jordan 
	}
	
	@Test
	public void testCreate() {
		final Order created = new Order(3L, 36L, 56.02);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 12L, 60.06));
		// expected.add(new Order(2L, 2L, 74.05)); not needed - test
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(2L, 2L, null), DAO.readLatest());
	}
 
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(1L, 12L, 60.06), DAO.read(ID));
	}
 
	@Test
	public void testUpdate() {
		final Order updated = new Order(3L, 36L, 56.02);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
