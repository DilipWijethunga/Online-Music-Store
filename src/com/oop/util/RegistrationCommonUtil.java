
package com.oop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.service.ICustomerService;

/**
 * This is the common utility class to load all property details at once when it
 * is initializing .
 */
public class RegistrationCommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ICustomerService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(RegistrationQueryUtil.class.getResourceAsStream(RegistrationCommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Customer ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = RegistrationCommonConstants.EMPLOYEE_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = RegistrationCommonConstants.EMPLOYEE_ID_PREFIX + next;
		}
		return id;
	}
}
