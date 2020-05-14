package com.oop.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.Cart;
import com.oop.util.DBConnect;

public class CartDAOImpl implements CartDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet  = null;
	
	
	@Override
	public List<Cart> get() {
		
		
		//reference variables
		List<Cart> list = null;
		Cart cart = null;
		
		
		try {
			list = new ArrayList<Cart>();
			
			
			//sql query
			String sql = "Select * from oop.cart";
			
			//DB connection
			connection = DBConnect.openConnection();
			
			//create a statement
			statement = connection.createStatement();
			
			//execute sql query
			resultSet = statement.executeQuery(sql);
			
			
			//processing the resultset
			while(resultSet.next()) {
				
				cart = new Cart();
				cart.setItemid(resultSet.getInt("itemid"));
				cart.setSongid(resultSet.getString("songid"));
				cart.setTitle(resultSet.getString("title"));
				cart.setPrice(resultSet.getDouble("price"));
				cart.setAlbum(resultSet.getString("album"));
				cart.setArtist(resultSet.getString("artist"));
				cart.setQuantity(resultSet.getInt("quantity"));
				
				list.add(cart);
			}		
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public boolean save(Cart c) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
	@Override
	public Cart get(int id) {
		Cart cart =null;

		try {
			cart = new Cart();
			String sql = "select * from oop.cart where songid='"+id+"'";
			
			connection = DBConnect.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				cart.setSongid(resultSet.getString("itemid"));
				cart.setTitle(resultSet.getString("title")); 
				cart.setPrice(resultSet.getDouble("price"));
				cart.setAlbum(resultSet.getString("album"));
				cart.setArtist(resultSet.getString("artist"));
				cart.setQuantity(resultSet.getInt("quantity"));
			}
		}
		
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cart;
		
	}

	
}
