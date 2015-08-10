package edu.scu.dp.smartcals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.NutritionalInfoDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.NutritionalInfoModel;

public class NutritionalInfoDaoImpl implements NutritionalInfoDao {

	private DatabaseFactory databaseFactory;
	private PreparedStatement statement = null;
	private NutritionalInfoModel nutriInfo;

	public NutritionalInfoDaoImpl(DatabaseFactory databaseFactory) {		
		this.databaseFactory = databaseFactory;		
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
			DBUtils.closeConnection(connection);
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
	 * @param result
	 * @throws SQLException 
	 */
	private void mapRow(ResultSet result) throws SQLException {

		//set all attributes from DB result set
		nutriInfo = new NutritionalInfoModel.
				NutriBuilder(result.getLong("ProductID"), result.getString("Calories"), result.getString("SmartTag")).
				servingSize(result.getString("ServingSize")).
				totalFat(result.getString("TotalFat")).
				buildNutriInfo();
	}

}
