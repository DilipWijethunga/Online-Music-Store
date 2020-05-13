package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	//database connection
			private static final String url = "jdbc:mysql://localhost:3306/oop";
			private static final String driver = "com.mysql.jdbc.Driver";
			private static final  String user = "root";
			private static final  String password = "1234";
			private static  Connection connection = null;
			
			public static Connection getConnection() {
				
				//checking connection
				if(connection != null) {
					return connection;
				}
				else {
					
					try {
						Class.forName(driver);
						
						connection = DriverManager.getConnection(url, user, password);
					
					}
					
					catch (Exception e) {
						e.printStackTrace();
					}
					
				
					return connection;
				}
				
				
			}
}
