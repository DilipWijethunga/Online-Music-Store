
package com.oop.model;

/**
 * This is the Employee model class
 */

public class Customers {

	private String CustomerID;
	
	private String CustomerName;

	private String CustomerPhone;

	private String CustomerAddress;
	
	private String Gender;

	private String CustomerEmail;

	private String UserName;
	
	private String Password;
		

	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return CustomerID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	/**
	 * @return the CustomerName
	 */
	public String getCustomerName() {
		return CustomerName;
	}

	/**
	 * @param customerName the CustomerName to set
	 */
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	/**
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return CustomerPhone;
	}

	/**
	 * @param customerPhone the customerPhone to set
	 */
	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}

	/**
	 * @return the facultyName
	 */
	public String getCustomerAddress() {
		return CustomerAddress;
	}

	/**
	 * @param facultyName the facultyName to set
	 */
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	/**
	 * @return the CustomerEmail
	 */
	public String getCustomerEmail() {
		return CustomerEmail;
	}

	/**
	 * @param CustomerEmail the CustomerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	/**
	 * @return the address
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @param address the address to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		
		return "Customer ID = " + CustomerID 
		+ "\n" + "Customer Name = " + CustomerName 
		+ "\n" + "CustomerEmail = " + CustomerEmail
		+ "\n" + "Customer Address = " + CustomerAddress 
		+ "\n" + "Gender = " + Gender
		+ "\n" + "CustomerPhone = "+ CustomerPhone 		
		+ "\n" + "UserName = " + UserName 		
		+ "\n" + "Password = " + Password ;
	}
}
