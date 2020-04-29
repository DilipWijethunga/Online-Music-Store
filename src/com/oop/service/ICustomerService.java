
package com.oop.service;

import com.oop.model.Customers;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

/**
 * Contract for the implementation of Customer Service .
 */
public interface ICustomerService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ICustomerService.class.getName());


	/**
	 * Add customers for customer table
	 * @param customer
	 */
	public void addCustomer(Customers customer);

	/**
	 * Get a particular Customer
	 * 
	 * @param customerID
	 * @return Employee
	 */
	public Customers getCustomerByID(String empoyeeID);
	
	/**
	 * Get all list of customers
	 * 
	 * @return ArrayList<Customers>
	 */
	public ArrayList<Customers> getCustomers();
	
	/**
	 * Update existing customer
	 * @param customerID
	 * @param customer
	 * 
	 * @return
	 */
	public Customers updateCustomers(String customerID, Customers customer);

	/**
	 * Remove existing customer
	 * 
	 * @param customerID
	 */
	public void removeCustomer(String customerID);

}
