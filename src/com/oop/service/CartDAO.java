package com.oop.service;

import java.util.List;

import com.oop.model.Cart;


public interface CartDAO {
	
	List<Cart> get();
	
	boolean save(Cart c);
	
	
	Cart get(int id);
}
