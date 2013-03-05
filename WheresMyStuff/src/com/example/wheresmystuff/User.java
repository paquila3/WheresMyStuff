package com.example.wheresmystuff;

import java.util.ArrayList;

public class User {
	private String username, password, user_android_id;
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
	
	boolean add(Item item){
		try{
		itemList.add(item);
		}
		catch(Exception e){
			return false;
		}
		return true;
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

	public String getUser_android_id() {
		return user_android_id;
	}

	public void setUser_android_id(String user_android_id) {
		this.user_android_id = user_android_id;
	}
}
