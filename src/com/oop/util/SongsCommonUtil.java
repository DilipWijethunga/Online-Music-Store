
package com.oop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.service.ISongService;

/**
 * This is the common utility class to load all property details at once when it
 * is initializing .
 */
public class SongsCommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ISongService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(SongsQueryUtil.class.getResourceAsStream(SongsCommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Song ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = SongsCommonConstants.SONG_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = SongsCommonConstants.SONG_ID_PREFIX + next;
		}
		return id;
	}
}
