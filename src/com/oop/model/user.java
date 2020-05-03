package com.oop.model;

public class user {
	private String id;
	private String name;
	private String address;
	private String Phone;
	private String gender;
	private String email;
	private String password;
	
	
	

	public user(String id, String name, String address, String phone, String gender, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		Phone = phone;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}




	public String getId() {
		return id;
	}




	public String getName() {
		return name;
	}







	public String getAddress() {
		return address;
	}

    public String getPhone() {
		return Phone;
	}


    public String getGender() {
		return gender;
	}


    public String getEmail() {
		return email;
	}

    public String getPassword() {
		return password;
	}







}
