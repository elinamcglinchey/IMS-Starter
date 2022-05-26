package com.qa.ims.persistence.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;
 
public class OrderItemDAO implements Dao<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override 
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderItemId = resultSet.getLong("orderItemId");
		Double cost = resultSet.getDouble("cost");
		String name = resultSet.getString("name");
		Long itemId = resultSet.getLong("itemId");
		return new OrderItem(orderItemId, cost, name, itemId);
	}
 
	/** 
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderitems");) {
			List<OrderItem> orderitems = new ArrayList<>();
			while (resultSet.next()) {
				orderitems.add(modelFromResultSet(resultSet));
			}
			return orderitems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderitems ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a orderitems in the database
	 * 
	 * @param orderitems - takes in a customer object. id will be ignored
	 */
	@Override
	public OrderItem create(OrderItem orderitems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderitems(orderItemId, cost, name, itemId) VALUES (?, ?)");) {
			statement.setLong(1, orderitems.getOrderItemId());
			statement.setDouble(2, orderitems.getCost());
			statement.setString(3, orderitems.getName());
			statement.setLong(4, orderitems.getItemId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderitems WHERE id = ?");) {
			// ASK - ID ("SELECT * FROM orderitems WHERE id = ?");
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public OrderItem update(OrderItem orderitems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orderitems SET orderItemId = ?, cost = ?, name = ?, itemId = ? WHERE id = ?");) {
			statement.setLong(1, orderitems.getOrderItemId());
			statement.setDouble(2, orderitems.getCost());
			statement.setString(3, orderitems.getName());
			statement.setLong(4, orderitems.getItemId());
			statement.executeUpdate();
			return read(orderitems.getOrderItemId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderitems WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	

}