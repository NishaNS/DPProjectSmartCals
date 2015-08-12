package edu.scu.dp.smartcals.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.SmartCardDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.SmartCard;

public class SmartCardDaoImpl implements SmartCardDao{
	
	private DatabaseFactory databaseFactory;
	private PreparedStatement statement;
	private SmartCard sc;
	private String query;

	public SmartCardDaoImpl(DatabaseFactory databaseFactory)
	{
		this.databaseFactory = databaseFactory;	
		statement = null;
		query = null;
	}
	@Override
	public SmartCard getSmartCardId(long id) throws SQLException,
			EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmartCard buySmartCard() throws SQLException, EmptyResultException{
		Connection connection = databaseFactory.getConnection();
		query = "insert into customer(CustomerName) values(?)";
		String name = "Sharadha";
		long no = 0;
		int cnt;
		try 
		{
			statement = connection.prepareStatement(query);
			statement.setString(1,name);
		    cnt = statement.executeUpdate();
		    if(cnt == 0)
		    	System.out.println("Error");
		    query = "select max(SmartCalCardNumber) from customer";
		    statement = connection.prepareStatement(query);
		    ResultSet rs = statement.executeQuery();
		    if(rs.next()){
		    	no = rs.getLong(1);
		    }
		    rs.close(); 
		    query = "insert into smartcalcarddetails(SmartCalCardNumber,CardBalance) values(?,?)";
		    statement = connection.prepareStatement(query);
		    statement.setLong(1,no);
		    statement.setDouble(2,0.0);
		    cnt = statement.executeUpdate();
		    if(cnt == 0)
		    	System.out.println("Error");
		    query = "select * from customer join smartcalcarddetails on customer.SmartCalCardNumber = smartcalcarddetails.SmartCalCardNumber where customer.SmartCalCardNumber = ?";
		    statement = connection.prepareStatement(query);
		    statement.setLong(1, no);
		    rs = statement.executeQuery();
			if(rs.next()) 
			{
				sc = mapRow(rs);
			}
			else 
			{
				throw new EmptyResultException();
		    }
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			DBUtils.closeStatement(statement);
			DBUtils.closeConnection(connection);
		}
		return sc;
	}

	private SmartCard mapRow(ResultSet resultSet) throws SQLException {
		SmartCard smt = new SmartCard();
		smt.setSmartCard(resultSet.getLong("SmartCalCardNumber"));
		smt.setName(resultSet.getString("CustomerName"));
		smt.setBalance(resultSet.getDouble("cardBalance"));
		return smt;
	}
	
	@Override
	public SmartCard loadSmartCard(long SmartCalCardNumber,double balance) throws SQLException, EmptyResultException{
		Connection connection = databaseFactory.getConnection();
		query = "update smartcalcarddetails set CardBalance = ? where SmartCalCardNumber = ?";  
	    int cnt;
		try 
		{
			statement = connection.prepareStatement(query);
			statement.setLong(2,SmartCalCardNumber);
			statement.setDouble(1,balance);
			cnt = statement.executeUpdate();
			if(cnt > 0)
			{
				query = "select * from customer join smartcalcarddetails on customer.SmartCalCardNumber = smartcalcarddetails.SmartCalCardNumber";
				statement = connection.prepareStatement(query);
				ResultSet rs = statement.executeQuery();
				if(rs.next()) 
				{
					sc = mapRow(rs);
				}
				else 
				{
					throw new EmptyResultException();
				}
			}	
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			DBUtils.closeStatement(statement);
			DBUtils.closeConnection(connection);
		}
		return sc;
	}

	@Override
	public void checkBalance(SmartCard smtcd) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}