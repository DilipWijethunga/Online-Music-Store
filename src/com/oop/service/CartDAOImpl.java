package com.oop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	PreparedStatement preparedStatement = null;
	
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
			connection = DBConnect.getConnection();
			
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
				
				//add to list
				list.add(cart);
			}		
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	


	
	
	@Override
	public Cart get(int itemid) {
		Cart cart =null;

		try {
			cart = new Cart();
			String sql = "select * from oop.cart where itemid="+itemid;
			
			connection = DBConnect.getConnection();
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
		
		System.out.print(cart.getSongid() + cart.getTitle() + cart.getPrice() + cart.getAlbum() + cart.getArtist() + cart.getQuantity());
		
		return cart;
		
	}


	//Insert data into cart table manually
	@Override
	public boolean save(Cart c) {
		boolean flag = false;
		
		try {
			String sql = "insert into oop.cart (songid, title, album, artist) values ('"+c.getSongid()+"', '"+c.getTitle()+"', '"+c.getAlbum()+"', '"+c.getArtist()+"')";
			connection = DBConnect.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}
			
		catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}







	@Override
	public boolean update(Cart c) {

			boolean flag = false;
			
			try {
				String sql = "update oop.cart set quantity='"+c.getQuantity()+"' where itemid="+c.getItemid();
				connection = DBConnect.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				flag = true;
			}
			
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			return flag;
	}





	@Override
	public boolean delete(int itemid) {
		
		boolean flag = false;
		
		try {
			String sql = "delete from oop.cart where itemid ="+itemid;
			connection = DBConnect.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}
		
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
}
