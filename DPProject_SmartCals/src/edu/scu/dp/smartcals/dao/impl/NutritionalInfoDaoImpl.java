package edu.scu.dp.smartcals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.NutritionalInfoDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.NutritionalInfoModel;

/**
 * Class to perform operations from NutritionalInfo table
 * @author Nisha Narayanaswamy
 *
 */
public class NutritionalInfoDaoImpl implements NutritionalInfoDao {

	private DatabaseFactory databaseFactory;
	private PreparedStatement statement = null;
	private NutritionalInfoModel nutriInfo;
	private static NutritionalInfoDao INSTANCE;

	private NutritionalInfoDaoImpl(DatabaseFactory databaseFactory) {		
		this.databaseFactory = databaseFactory;		
	}

	/**
	 * Implementation of Singleton pattern as there should be only NutritionalInfoDao for 
	 * the entire application
	 * @param databaseFactory
	 * @return
	 */
	public static NutritionalInfoDao getInstance(DatabaseFactory databaseFactory) {
		if(INSTANCE == null){
			INSTANCE = new NutritionalInfoDaoImpl(databaseFactory);
		}
		return INSTANCE;
	}

	@Override
	public NutritionalInfoModel getNutriInfo(long prodID) throws SQLException, EmptyResultException {

		Connection connection = databaseFactory.getConnection();
		try {

			statement = connection.prepareStatement("Select * From NutritionalInfo Where ProductID = ?");		
			statement.setLong(1, prodID);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				mapRow(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}
		return nutriInfo;
	}


	@Override
	public void addNutriInfo(long prodID) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNutriInfo(long prodID) throws SQLException {
		// TODO Auto-generated method stub

	}

	//maybe add method to get smart tags

	/**
	 * Map the result set data to the model object
	 * @param result
	 * @throws SQLException 
	 */
	private void mapRow(ResultSet result) throws SQLException {

		//set all attributes from DB result set
		nutriInfo = new NutritionalInfoModel.
				NutriBuilder(result.getLong("ProductID"), result.getString("Calories"), result.getString("SmartTag")).
				servingSize(result.getString("ServingSize")).
				totalFat(result.getString("TotalFat")).
				saturatedFat(result.getString("SaturatedFat")).
				transFat(result.getString("TransFat")).
				cholestrol(result.getString("Cholestrol")).
				sodium(result.getString("Sodium")).
				totalCarbs(result.getString("TotalCarbs")).
				dietaryFiber(result.getString("DietaryFiber")).
				sugars(result.getString("Sugars")).
				protein(result.getString("Protein")).
				iron(result.getString("Iron")).
				buildNutriInfo();
	}

}
