package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;

import edu.scu.dp.smartcals.model.AdminLoginModel;

/**
 * @author Nisha Narayanaswamy
 * 
 * Administrator Login DAO
 */
public interface AdminLoginDao {
	
	public AdminLoginModel getAdminDetails(String username, String password) throws SQLException;
	
	public void setLastLoginTime(String username) throws SQLException;
	
	public void setLoginFailedAttempt(String username) throws SQLException;

}
