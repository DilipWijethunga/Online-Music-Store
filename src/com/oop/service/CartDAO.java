package com.oop.service;

import java.util.List;

import com.oop.model.Cart;


public interface CartDAO {
	
	List<Cart> get();
	
	//add items
	boolean save(Cart c);
	
	
	Cart get(int id);
	
	//update cart
	boolean update(Cart c);
	
	
	//delete from cart
	boolean delete (int itemid);
}
