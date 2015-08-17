package edu.scu.dp.smartcals.dao.impl;

import java.net.ConnectException;
import java.sql.*;

import edu.scu.dp.smartcals.dao.interfaces.AdminLoginDao;
import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.model.AdminLoginModel;

/**
 * @author Nisha Narayanaswamy
 * 
 * Class to fetch user credentials from AdministratorLogin table
 *
 */
public class AdminLoginDaoImpl implements AdminLoginDao {

	private DatabaseFactory databaseFactory;
	private PreparedStatement statement = null;
	private AdminLoginModel adminLogin;
	private static AdminLoginDao INSTANCE;

	//Hidden construtor since we are using Singleton design pattern
	private AdminLoginDaoImpl(DatabaseFactory databaseFactory) {
		this.databaseFactory = databaseFactory;
	}

	/**
	 * Implementation of Singleton pattern as there should be only one AdminLoginDao for 
	 * the entire application
	 * @param databaseFactory
	 * @return
	 */
	public static AdminLoginDao getInstance(DatabaseFactory databaseFactory){
		if(INSTANCE == null)
			INSTANCE = new AdminLoginDaoImpl(databaseFactory);
		return INSTANCE;		
	}

	@Override
	public AdminLoginModel getAdminDetails(String username, String password) throws SQLException {
		try {
			Connection connection = databaseFactory.getConnection();
			statement = connection.prepareStatement("Select * From AdministratorLogin Where UserName = ? And Password = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			
			if(result.next() && (result != null)){
				//if result set not null then login credentials match
				System.out.println("Login Successful");				
				mapRow(result);
			}
			else {
				System.out.println("Login attempt failed! Please try again.");
				//clear any old model data
				adminLogin.resetModel();
				
				//$$$$$$$$$ Code to write failed attempt to DB pending $$$$$$$$
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}		
		return adminLogin;
	}

	/**
	 * Map the result set data to the model object
	 * @param result
	 * @throws SQLException 
	 */
	private void mapRow(ResultSet result) throws SQLException {		

		//set all attributes from DB result set
		adminLogin = new AdminLoginModel();
		adminLogin.setUsername(result.getString("UserName"));
		adminLogin.setPassword(result.getString("Password"));
		adminLogin.setLoginAttempts(result.getInt("LoginAttempts"));
		adminLogin.setVendingMachineID(result.getInt("VendingMachineID"));
		adminLogin.setLocation(result.getString("Location"));
		adminLogin.setLoginTimeStamp(result.getTimestamp("LoginTimeStamp"));			

}



}
