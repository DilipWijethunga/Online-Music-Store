package com.oop.model;

public class Cart {
	
		//define fields 
		private int itemid;
		private String songid;
		private String title;
		private double price;
		private String album;
		private String artist;
		private int quantity;
		
		
		//setters and getters
		public int getItemid() {
			return itemid;
		}
		public String getSongid() {
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
		public int getQuantity() {
			return quantity;
		}
		public void setItemid(int itemid) {
			this.itemid = itemid;
		}
		public void setSongid(String songid) {
			this.songid = songid;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public void setAlbum(String album) {
			this.album = album;
		}
		public void setArtist(String artist) {
			this.artist = artist;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		
		
		//to string
		@Override
		public String toString() {
			return "Cart [itemid=" + itemid + ", songid=" + songid + ", title=" + title + ", price=" + price
					+ ", album=" + album + ", artist=" + artist + ", quantity=" + quantity + "]";
		}
		
		
		
		
		
		
		
		
}
