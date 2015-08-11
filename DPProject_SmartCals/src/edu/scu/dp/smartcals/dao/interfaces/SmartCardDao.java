package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.SmartCard;

public interface SmartCardDao {
	public SmartCard getSmartCardId(long id) throws SQLException, EmptyResultException;
	
	public SmartCard buySmartCard() throws SQLException, EmptyResultException;
	
	public SmartCard loadSmartCard(long SmartCalCardNumber,double balance) throws SQLException,EmptyResultException;
	
	public void checkBalance(SmartCard smtcd) throws SQLException;
	
	
}