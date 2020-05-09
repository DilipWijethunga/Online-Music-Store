package com.search;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Songs {
	private int songid;
	private String title;
	private double price;
	private String album;
	private String artist;
	
	
	public Songs(int songid, String title, double price, String album, String artist) {
		super();
		this.songid = songid;
		this.title = title;
		this.price = price;
		this.album = album;
		this.artist = artist;
	}


	public int getSongid() {
		return songid;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
	}

	
	
	
}

