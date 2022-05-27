package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

@Ignore
public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

//	@Before
//	public void insert() {
//		final Item created1= new Item(1L, 5.99, "calculator");
//		final Item created2 = new Item (2L, 1.20, "sharpener");
//		DAO.create(created1);
//		DAO.create(created2);
//		// Data didn't appear as I wanted to in schema, implemented data inside the test
//		
//	}
	
	@Test
	public void testCreate() {
		final Item created = new Item(3L, 3.85, "bottle");
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		// EXAMPLE FORMAT - expected.add(new Customer(1L, "jordan", "harrison", "jharrisson", "j1h2344"));
		expected.add(new Item(1L, 5.99, "calculator"));
		// expected.add(new Item(2L, 1.20, "sharpener"));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(2L, 1.20, "sharpener"), DAO.readLatest());
	}
 
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID,  5.99, "calculator"), DAO.read(ID));
	}
 
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, 3.85, "bottle");
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}