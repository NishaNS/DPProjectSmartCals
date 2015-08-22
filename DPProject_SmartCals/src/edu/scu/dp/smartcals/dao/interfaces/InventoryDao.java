package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.InventoryModel;
import edu.scu.dp.smartcals.model.ProductModel;

public interface InventoryDao {

	public InventoryModel getProductById(long id) throws SQLException, EmptyResultException;
}
