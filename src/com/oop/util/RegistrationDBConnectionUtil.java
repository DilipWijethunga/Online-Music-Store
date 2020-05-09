
package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is the Database connection creation class .
 */
public class RegistrationDBConnectionUtil extends RegistrationCommonUtil {

	private static Connection connection;

	// This works according to singleton pattern
	private RegistrationDBConnectionUtil() {
	}

	/**
	 * Create Database connection for the given URL, Username and Password
	 * 
	 * @return Connection this returns SQL connection for MySql Database
	 * 
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name
	 * @throws SQLException
	 *             - An exception that provides information on a database access
	 *             error or other errors
	 */
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is
		 * null
		 */
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(RegistrationCommonConstants.DRIVER_NAME));
			connection = DriverManager.getConnection(properties.getProperty(RegistrationCommonConstants.URL),
					properties.getProperty(RegistrationCommonConstants.USERNAME), properties.getProperty(RegistrationCommonConstants.PASSWORD));
		}
		return connection;
	}
}










