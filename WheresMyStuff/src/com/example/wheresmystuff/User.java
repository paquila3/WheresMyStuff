package com.example.wheresmystuff;

import java.util.ArrayList;

public class User {
	private String username, password;
	private boolean admin, locked;
	private ArrayList<Item> itemList= new ArrayList<Item>();
	
	public User(String username, String password) {
		this(username, password, false);
	}
	
	public User(String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
		locked = false;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked=locked;
		
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
}
