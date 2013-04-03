package com.example.wheresmystuff.model;

import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {
	
	/** The user_android_id. */
	private String username, password, user_android_id;
	
	/** The locked. */
	private boolean admin, locked;
	
	
	private int userID;
	/** The item list. */
	private ArrayList<Item> itemList= new ArrayList<Item>();
	
	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public User(String username, String password, int userID) {
		this(username, password, false, userID);
		
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param admin the admin
	 */
	public User(String username, String password, boolean admin, int userID) {
		this.username = username;
		this.password = password;
		this.admin = admin;
		locked = false;
		this.userID = userID;
	}
	
	/**
	 * Adds the item.
	 *
	 * @param item the item
	 * @return true, if successful
	 */
	public boolean addItem(Item item){
		try{
		itemList.add(item);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Checks if is admin.
	 *
	 * @return true, if is admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	
	/**
	 * Sets the admin.
	 *
	 * @param admin the new admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	/**
	 * Checks if is locked.
	 *
	 * @return true, if is locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Sets the locked.
	 *
	 * @param locked the new locked
	 */
	public void setLocked(boolean locked) {
		this.locked=locked;
		
	}

	/**
	 * Gets the item list.
	 *
	 * @return the item list
	 */
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	

	/**
	 * Sets the item list.
	 *
	 * @param itemList the new item list
	 */
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return username;
	}
	
	/**
	 * Gets the user_android_id.
	 *
	 * @return the user_android_id
	 */
	public String getUser_android_id() {
		return user_android_id;
	}

	/**
	 * Sets the user_android_id.
	 *
	 * @param user_android_id the new user_android_id
	 */
	public void setUser_android_id(String user_android_id) {
		this.user_android_id = user_android_id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
