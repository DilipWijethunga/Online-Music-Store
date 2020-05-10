package com.oop.util;
import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.Songs;


public class SearchDBUtil {
	
	public static List<Songs> search(String srchtext){
		
		ArrayList<Songs> song = new ArrayList<>();
		
		//database connection
		String url = "jdbc:mysql://localhost:3306/oop";
		String user = "root";
		String password = "1234";
		
		
		//validating
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			String sql = "select * from songs where title= '"+srchtext+"' ";
			ResultSet res = stmt.executeQuery(sql);
					
			if (res.next()) {
				int songid = res.getInt(1);
				String title = res.getString(2);
				double price = res.getDouble(3);
				String album = res.getString(4);
				String artist = res.getString(5);
				
				Songs song1 = new Songs(songid, title, price, album, artist);
				song.add(song1);
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return song;
	}
}
