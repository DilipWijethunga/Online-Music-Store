package com.oop.model;

/**
 * This is the AddSongs model class
 */

public class AddSongs {

	private String SongID;
	
	private String SongName;

	private String Artist;

	private String Duration;
	
	private String Album;

	private String Genre;

	private String Composer;
	
	private String Year;
		

	/**
	 * @return the SongID
	 */
	public String getSongID() {
		return SongID;
	}

	/**
	 * @param SongID the SongID to set
	 */
	public void setSongID(String songID) {
		SongID = songID;
	}
	
	/**
	 * @return the SongName
	 */
	public String getSongName() {
		return SongName;
	}

	/**
	 * @param SongName the SongName to set
	 */
	public void setSongName(String songName) {
		SongName = songName;
	}

	/**
	 * @return the Artist
	 */
	public String getArtist() {
		return Artist;
	}

	/**
	 * @param Artist the Artist to set
	 */
	public void setArtist(String artist) {
		Artist = artist;
	}

	/**
	 * @return the Duration
	 */
	public String getDuration() {
		return Duration;
	}

	/**
	 * @param Duration the Duration to set
	 */
	public void setDuration(String duration) {
		Duration = duration;
	}

	/**
	 * @return the Album
	 */
	public String getAlbum() {
		return Album;
	}

	/**
	 * @param Album the Album to set
	 */
	public void setAlbum(String album) {
		Album = album;
	}

	/**
	 * @return the Genre
	 */
	public String getGenre() {
		return Genre;
	}

	/**
	 * @param Genre the Genre to set
	 */
	public void setGenre(String genre) {
		Genre = genre;
	}

	/**
	 * @return the Composer
	 */
	public String getComposer() {
		return Composer;
	}

	/**
	 * @param Composer the Composer to set
	 */
	public void setComposer(String composer) {
		Composer = composer;
	}

	/**
	 * @return the Year
	 */
	public String getYear() {
		return Year;
	}

	/**
	 * @param Year the Year to set
	 */
	public void setYear(String year) {
		Year = year;
	}

	@Override
	public String toString() {
		
		return "Song ID = " + SongID 
		+ "\n" + "Song Name = " + SongName 
		+ "\n" + "Artist = " + Artist
		+ "\n" + "Duration = " + Duration 
		+ "\n" + "Album = " + Album                                                                                 
		+ "\n" + "Genre = "+ Genre 		
		+ "\n" + "Composer = " + Composer 		
		+ "\n" + "Year = " + Year ;
	}
}
