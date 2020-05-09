
package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.oop.model.Customers;
import com.oop.util.RegistrationCommonConstants;
import com.oop.util.RegistrationCommonUtil;
import com.oop.util.RegistrationDBConnectionUtil;
import com.oop.util.RegistrationQueryUtil;

/**
 * Contract for the implementation of Customer Service .
 */

public class CustomerServiceImpl implements ICustomerService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createRegistrationTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing registration table in the database and
	 * recreate table structure to insert customer entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */
	public static void createRegistrationTable() {

		try {
			connection = RegistrationDBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			////////statement.executeUpdate(RegistrationQueryUtil.queryByID(RegistrationCommonConstants.QUERY_ID_DROP_TABLE));
			// Create new registration table as per SQL query available in
			// Query.xml
			statement.executeUpdate(RegistrationQueryUtil.queryByID(RegistrationCommonConstants.QUERY_ID_CREATE_TABLE));
			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of customers for as a batch from the selected customer List
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * 
	 */
	@Override
	public void addCustomer(Customers customer) {

		String customerID = RegistrationCommonUtil.generateIDs(getCustomerIDs());
		
		try {
			connection = RegistrationDBConnectionUtil.getDBConnection();
			/*
			 * Query is available in RegistrationQuery.xml file and use
			 * insert_customer key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(RegistrationQueryUtil.queryByID(RegistrationCommonConstants.QUERY_ID_INSERT_EMPLOYEES));
			connection.setAutoCommit(false);
			
			//Generate customer IDs
			customer.setCustomerID(customerID);
			preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_ONE, customer.getCustomerID());
			preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_TWO, customer.getCustomerName());
			preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_THREE, customer.getCustomerPhone());
			preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_FOUR, customer.getCustomerAddress());
			preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_FIVE, customer.getGender());
			preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_SIX, customer.getCustomerEmail());
			preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_SEVEN, customer.getUserName());
			preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_EIGHT, customer.getPassword());
			// Add customer
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * Customer details can be retrieved based on the provided customer ID
	 * 
	 * @param customerID
	 *            - Customer details are filtered based on the ID
	 * 
	 * @see #actionOnCustomer()
	 */
	@Override
	public Customers getCustomerByID(String customerID) {

		return actionOnCustomer(customerID).get(0);
	}
	
	/**
	 * Get all list of employees
	 * 
	 * @return ArrayList<Customers> 
	 * 						- Array of customer list will be return
	 * 
	 * @see #actionOnCustomer()
	 */
	@Override
	public ArrayList<Customers> getCustomers() {
		
		return actionOnCustomer(null);
	}

	/**
	 * This method delete an customer based on the provided ID
	 * 
	 * @param customerID
	 *            - Delete customer according to the filtered customer details
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	@Override
	public void removeCustomer(String customerID) {

		// Before deleting check whether customer ID is available
		if (customerID != null && !customerID.isEmpty()) {
			/*
			 * Remove customer query will be retrieved from RegistrationQuery.xml
			 */
			try {
				connection = RegistrationDBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(RegistrationQueryUtil.queryByID(RegistrationCommonConstants.QUERY_ID_REMOVE_EMPLOYEE));
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_ONE, customerID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs GET customer by ID and Display all employees
	 * 
	 * @param customerID
	 *            ID of the customer to remove or select from the list

	 * @return ArrayList<Employee> Array of customer list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @see #getCustomers()
	 * @see #getCustomerByID(String)
	 */
	private ArrayList<Customers> actionOnCustomer(String customerID) {

		ArrayList<Customers> customerList = new ArrayList<Customers>();
		try {
			connection = RegistrationDBConnectionUtil.getDBConnection();
			/*
			 * Before fetching customer it checks whether customer ID is
			 * available
			 */
			if (customerID != null && !customerID.isEmpty()) {
				/*
				 * Get customer by ID query will be retrieved from
				 * RegistrationQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(RegistrationQueryUtil.queryByID(RegistrationCommonConstants.QUERY_ID_GET_EMPLOYEE));
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_ONE, customerID);
			}
			/*
			 * If customer ID is not provided for get customer option it display
			 * all customers
			 */
			else {
				preparedStatement = connection
						.prepareStatement(RegistrationQueryUtil.queryByID(RegistrationCommonConstants.QUERY_ID_ALL_EMPLOYEES));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Customers customer = new Customers();
				customer.setCustomerID(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_ONE));
				customer.setCustomerName(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_TWO));
				customer.setCustomerPhone(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_THREE));
				customer.setCustomerAddress(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_FOUR));
				customer.setGender(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_FIVE));
				customer.setCustomerEmail(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_SIX));
				customer.setUserName(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_SEVEN));
				customer.setPassword(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_EIGHT));
				customerList.add(customer);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return customerList;
	}

	/**
	 * Get the updated customer
	 * 
	 * @param customerID
	 *            ID of the customer to remove or select from the list
	 * 
	 * @return return the Customers object
	 * 
	 */
	@Override
	public Customers updateCustomers(String customerID, Customers customer) {

		/*
		 * Before fetching customer it checks whether customer ID is available
		 */
		if (customerID != null && !customerID.isEmpty()) {
			/*
			 * Update customer query will be retrieved from RegistrationQuery.xml
			 */
			try {
				connection = RegistrationDBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(RegistrationQueryUtil.queryByID(RegistrationCommonConstants.QUERY_ID_UPDATE_EMPLOYEE));
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_ONE, customer.getCustomerName());
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_TWO, customer.getCustomerPhone());
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_THREE, customer.getCustomerAddress());
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_FOUR, customer.getGender());
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_FIVE, customer.getCustomerEmail());
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_SIX, customer.getUserName());
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_SEVEN, customer.getPassword());			
				preparedStatement.setString(RegistrationCommonConstants.COLUMN_INDEX_EIGHT, customer.getCustomerID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated customer
		return getCustomerByID(customerID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of customer id list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	private ArrayList<String> getCustomerIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of customer IDs will be retrieved from RegistrationQuery.xml
		 */
		try {
			connection = RegistrationDBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(RegistrationQueryUtil.queryByID(RegistrationCommonConstants.QUERY_ID_GET_EMPLOYEE_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(RegistrationCommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
