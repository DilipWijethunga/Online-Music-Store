package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CartDBUtil {

	public static boolean Insertcart(String songid, String title, double price, String album, String artist, String quantity) {
		
		int sid = Integer.parseInt(songid);
		double sprice = Double.parseDouble(price);
		int qty = Integer.parseInt(quantity);
		
		boolean isSuccess = false;
		
		//Database connection
		String url = "jdbc:mysql://localhost:3306/oop";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			String sql = "insert into oop.cart values ('"+sid+"', '"+title+"', '"+sprice+"', '"+album+"', '"+artist+"', '"+qty+"')";
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
