package com.oop.service;

import com.oop.model.AddSongs;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

/**
 * Contract for the implementation of Song Service .
 */
public interface ISongService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ISongService.class.getName());


	/**
	 * Add songs for song table
	 * @param songs
	 */
	public void addSongs(AddSongs songs);

	/**
	 * Get a particular Song
	 * 
	 * @param songID
	 * @return Song
	 */
	public AddSongs getSongByID(String songID);
	
	/**
	 * Get all list of songs
	 * 
	 * @return ArrayList<Songs>
	 */
	public ArrayList<AddSongs> getSongs();
	
	/**
	 * Update existing song
	 * @param songID
	 * @param songs
	 * 
	 * @return
	 */
	public AddSongs updateSongs(String songID, AddSongs song);

	/**
	 * Remove existing song
	 * 
	 * @param songID
	 */
	public void removeSongs(String songID);

}
