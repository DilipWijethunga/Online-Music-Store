package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CartDBUtil {

	public static boolean Insertcart(String title, String price, String album, String artist, String quantity) {
		
		
		
		boolean isSuccess = false;
		
		//Database connection
		String url = "jdbc:mysql://localhost:3306/oop";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			String sql = "insert into oop.cart values (0, '"+title+"', '"+price+"', '"+album+"', '"+artist+"', quantity)";
			int res = stmt.executeUpdate(sql);
			
			if(res > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		
		catch(Exception e) {
			e.fillInStackTrace();
			}
		
		return isSuccess;
	}
}
