package edu.scu.dp.smartcals.dao.impl;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.SmartCardDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.SmartCardModel;

public class SmartCardDaoImpl implements SmartCardDao{
	
	private DatabaseFactory databaseFactory;
	private PreparedStatement statement;
	private SmartCardModel sc;
	private String query;
	private static SmartCardDao INSTANCE;

	public SmartCardDaoImpl(DatabaseFactory databaseFactory)
	{
		this.databaseFactory = databaseFactory;	
		statement = null;
		query = null;
	}
	
	/**
	 * Implementation of Singleton pattern.
	 * There should be only one ProductDAO instance for the entire application
	 * @param databaseFactory
	 * @return
	 */
	public static SmartCardDao getInstance(DatabaseFactory databaseFactory){
		if(INSTANCE == null) {
			INSTANCE = new SmartCardDaoImpl(databaseFactory);
		}
		return INSTANCE;
	}
	
	@Override
	public SmartCardModel getSmartCardId(long id) throws SQLException,
			EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmartCardModel buySmartCard() throws SQLException, EmptyResultException{
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
			databaseFactory.closeConnection();
		}
		return sc;
	}

	private SmartCardModel mapRow(ResultSet resultSet) throws SQLException {
		SmartCardModel smt = new SmartCardModel();
		smt.setSmartCard(resultSet.getLong("SmartCalCardNumber"));
		smt.setName(resultSet.getString("CustomerName"));
		smt.setBalance(resultSet.getDouble("cardBalance"));
		return smt;
	}
	
	@Override
	public SmartCardModel loadSmartCard(long SmartCalCardNumber,double balance) throws SQLException, EmptyResultException{
		Connection connection = databaseFactory.getConnection();
		double avail = 0.0;
		ResultSet rs ;
		query = "select CardBalance from smartcalcarddetails where SmartCalCardNumber = ?";
		statement = connection.prepareStatement(query);
		statement.setLong(1,SmartCalCardNumber);
		rs = statement.executeQuery();
		if(rs.next()){
			avail = rs.getDouble("CardBalance");
		}
		rs.close();
		balance = balance + avail;
		System.out.println(balance);
		query = "update smartcalcarddetails set CardBalance = ? where SmartCalCardNumber = ?";  
	    int cnt;
		try 
		{
			statement = connection.prepareStatement(query);
			statement.setLong(2,SmartCalCardNumber);
			statement.setDouble(1,balance);
			cnt = statement.executeUpdate();
			rs.close();
			if(cnt > 0)
			{
				query = "select * from customer join smartcalcarddetails on customer.SmartCalCardNumber = smartcalcarddetails.SmartCalCardNumber where customer.SmartCalCardNumber = '" +SmartCalCardNumber+"'";
				statement = connection.prepareStatement(query);
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
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}
		return sc;
	}

	@Override
	public void checkBalance(SmartCardModel smtcd) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
