package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.SmartCardModel;

public interface SmartCardDao {
	public SmartCardModel getSmartCardId(long id) throws SQLException, EmptyResultException;
	
	public SmartCardModel buySmartCard() throws SQLException, EmptyResultException;
	
	public SmartCardModel loadSmartCard(long SmartCalCardNumber,double balance) throws SQLException,EmptyResultException;
	
	public void checkBalance(SmartCardModel smtcd) throws SQLException;
	
	
}
