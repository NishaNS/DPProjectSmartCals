/**
 * 
 */
package edu.scu.dp.smartcals.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DBUtils class to close the database connection
 * @author Aparna Ganesh
 *
 */
public class DBUtils {

	public static void closeConnection(Connection connection) throws SQLException {

		if (connection != null) {
			connection.close();

		}
	}
		public static void closeStatement(Statement statement) throws SQLException {

			if (statement != null) {
				statement.close();

			}

	}

}
