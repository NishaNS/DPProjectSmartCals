package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.NutritionalInfoModel;

/**
 * @author Nisha Narayanaswamy
 * 
 * Data Access Object for Nutritional Infotmation
 *
 */
public interface NutritionalInfoDao {
	
	/**
	 * @param prodID ProductID to be searched against
	 * @return 
	 * @throws SQLException
	 * @throws EmptyResultException
	 */
	public NutritionalInfoModel getNutriInfo(long prodID) throws SQLException, EmptyResultException;
	
	public void addNutriInfo(long prodID) throws SQLException;
	
	public void updateNutriInfo(long prodID) throws SQLException;

}
