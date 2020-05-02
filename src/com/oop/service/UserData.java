package com.oop.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.user;


public class UserData {
	
	public static List<user> validate(String email,String password){
		
		ArrayList<user> us=new ArrayList<>();
		
		//DB connection
		String url="jdbc:mysql://localhost:3306/oop";
		String user="root";
		String pass="root";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement state = conn.createStatement();
			String sql = "select * from user where email='"+email+"'and password='"+password+"'";
			ResultSet rs = state.executeQuery(sql);
			
			if(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String ema = rs.getString(3);
				String address = rs.getString(4);
				String passw = rs.getString(5);
				String phone = rs.getString(6);
				String gender = rs.getString(7);
				
				user u = new user(id,name,ema,address,passw,phone,gender);
				us.add(u);
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return us;
		
	}
	public static boolean insertfeedback(String name,String email,String message) {
		  
		  boolean isSuccess = false;
		  
		//DB connection

		    String url="jdbc:mysql://localhost:3306/oop";
			String user="root";
			String pass="root";
			
			try {
	           Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement state = conn.createStatement();
				String sql = "insert into feedback values('"+name+"','"+email+"','"+message+"')";
				int rs  = state.executeUpdate(sql);
				
				if(rs >0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
			}
				catch(Exception e){
					e.printStackTrace();
				}
			
		  
		  return isSuccess;
		  
}
}
