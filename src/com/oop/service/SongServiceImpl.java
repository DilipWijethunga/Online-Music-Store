
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

import com.oop.model.Songs;
import com.oop.util.SongsCommonConstants;
import com.oop.util.SongsCommonUtil;
import com.oop.util.SongsDBConnectionUtil;
import com.oop.util.SongsQueryUtil;

/**
 * Contract for the implementation of Song Service .
 */

public class SongServiceImpl implements ISongService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createSongsTable();
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
	public static void createSongsTable() {

		try {
			connection = SongsDBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			//Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(SongsQueryUtil.queryByID(SongsCommonConstants.QUERY_ID_DROP_TABLE));
			// Create new song table as per SQL query available in
			// SongsQuery.xml
			////////////////////////////////////////////////////////////////////////////////////////////
			statement.executeUpdate(SongsQueryUtil.queryByID(SongsCommonConstants.QUERY_ID_CREATE_TABLE));
			/////////////////////////////////////////////////////////////////////////////////////////////
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of songs for as a batch from the selected song List
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
	public void addSongs(Songs songs) {

		String songID = SongsCommonUtil.generateIDs(getSongIDs());
		
		try {
			connection = SongsDBConnectionUtil.getDBConnection();
			/*
			 * Query is available in RegistrationQuery.xml file and use
			 * insert_customer key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(SongsQueryUtil.queryByID(SongsCommonConstants.QUERY_ID_INSERT_SONGS));
			connection.setAutoCommit(false);
			
			//Generate song IDs
			songs.setSongID(songID);
			preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_ONE, songs.getSongID());
			preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_TWO, songs.getSongName());
			preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_THREE, songs.getArtist());
			preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_FOUR, songs.getDuration());
			preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_FIVE, songs.getAlbum());
			preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_SIX, songs.getGenre());
			preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_SEVEN, songs.getComposer());
			preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_EIGHT, songs.getYear());
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
	 * Song details can be retrieved based on the provided song ID
	 * 
	 * @param customerID
	 *            - Song details are filtered based on the ID
	 * 
	 * @see #actionOnSongs()
	 */
	@Override
	public Songs getSongByID(String songID) {

		return actionOnSongs(songID).get(0);
	}
	
	/**
	 * Get all list of songs
	 * 
	 * @return ArrayList<Songs> 
	 * 						- Array of song list will be return
	 * 
	 * @see #actionOnSongs()
	 */
	@Override
	public ArrayList<Songs> getSongs() {
		
		return actionOnSongs(null);
	}

	/**
	 * This method delete a song based on the provided ID
	 * 
	 * @param songID
	 *            - Delete song according to the filtered song details
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
	public void removeSongs(String songID) {

		// Before deleting check whether song ID is available
		if (songID != null && !songID.isEmpty()) {
			/*
			 * Remove customer query will be retrieved from RegistrationQuery.xml
			 */
			try {
				connection = SongsDBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(SongsQueryUtil.queryByID(SongsCommonConstants.QUERY_ID_REMOVE_SONG));
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_ONE, songID);
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
	 * This performs GET song by ID and Display all songs
	 * 
	 * @param songID
	 *            ID of the song to remove or select from the list

	 * @return ArrayList<Songs> Array of song list will be return
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
	 * @see #getSongss()
	 * @see #getSongByID(String)
	 */
	private ArrayList<Songs> actionOnSongs(String songID) {

		ArrayList<Songs> songList = new ArrayList<Songs>();
		try {
			connection = SongsDBConnectionUtil.getDBConnection();
			/*
			 * Before fetching customer it checks whether customer ID is
			 * available
			 */
			if (songID != null && !songID.isEmpty()) {
				/*
				 * Get song by ID query will be retrieved from
				 * SongsQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(SongsQueryUtil.queryByID(SongsCommonConstants.QUERY_ID_GET_SONG));
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_ONE, songID);
			}
			/*
			 * If song ID is not provided for get song option it display
			 * all songs
			 */
			else {
				preparedStatement = connection
						.prepareStatement(SongsQueryUtil.queryByID(SongsCommonConstants.QUERY_ID_ALL_SONGS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Songs songs = new Songs();
				songs.setSongID(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_ONE));
				songs.setSongName(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_TWO));
				songs.setArtist(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_THREE));
				songs.setDuration(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_FOUR));
				songs.setAlbum(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_FIVE));
				songs.setGenre(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_SIX));
				songs.setComposer(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_SEVEN));
				songs.setYear(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_EIGHT));
				songList.add(songs);
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
		return songList;
	}

	/**
	 * Get the updated song
	 * 
	 * @param songID
	 *            ID of the song to remove or select from the list
	 * 
	 * @return return the Songs object
	 * 
	 */
	@Override
	public Songs updateSongs(String songID, Songs songs) {

		/*
		 * Before fetching song it checks whether song ID is available
		 */
		if (songID != null && !songID.isEmpty()) {
			/*
			 * Update customer query will be retrieved from RegistrationQuery.xml
			 */
			try {
				connection = SongsDBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(SongsQueryUtil.queryByID(SongsCommonConstants.QUERY_ID_UPDATE_SONG));
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_ONE, songs.getSongName());
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_TWO, songs.getArtist());
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_THREE, songs.getDuration());
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_FOUR, songs.getAlbum());
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_FIVE, songs.getGenre());
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_SIX, songs.getComposer());
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_SEVEN, songs.getYear());			
				preparedStatement.setString(SongsCommonConstants.COLUMN_INDEX_EIGHT, songs.getSongID());
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
		// Get the updated song
		return getSongByID(songID);
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
	private ArrayList<String> getSongIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of customer IDs will be retrieved from RegistrationQuery.xml
		 */
		try {
			connection = SongsDBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(SongsQueryUtil.queryByID(SongsCommonConstants.QUERY_ID_GET_SONG_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(SongsCommonConstants.COLUMN_INDEX_ONE));
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
