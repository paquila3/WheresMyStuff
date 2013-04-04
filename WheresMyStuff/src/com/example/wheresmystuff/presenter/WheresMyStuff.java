package com.example.wheresmystuff.presenter;

import java.util.Calendar;

import android.app.Application;
import java.util.ArrayList;

import com.example.wheresmystuff.model.FoundItem;
import com.example.wheresmystuff.model.Item;
import com.example.wheresmystuff.model.LostItem;
import com.example.wheresmystuff.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class WheresMyStuff.
 */
public class WheresMyStuff extends Application {

	/** The current time. */
	public static Calendar currentTime = Calendar.getInstance();
	
	/** The user list. */
	private static ArrayList<User> userList = new ArrayList<User>();
	

	private static ArrayList<Item> itemList = new ArrayList<Item>();
	
	/** The active user. */
	private static User activeUser;
	
	private static DatabaseHelper Database;
	/**
	 * Initialize.
	 */
	public static void initialize() {
		System.out.println("12");
		if (Database.getUserCount()>0){
			return;
		}
		System.out.println("17");
		setActiveUser(createUser("a@m", "aaaa"));
		activeUser.setAdmin(true);
	}
	
	/**
	 * Creates the user.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the user
	 */
	public static User createUser(String email, String password) {
		User newUser;
		try{
			newUser=new User(email, password, Database.getUserCount());
			userList.add(newUser);
		}
		catch (NullPointerException e){
			newUser=new User(email,password,0);
			userList.add(newUser);
		}
		System.out.println(newUser.toString());
		System.out.println(Database.toString());
		Database.addUser(newUser);
		return newUser;
	}
	
	/**
	 * Creates the clone.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the user
	 */
	public static User createClone(String email, String password) {//cory
		User newUser=new User(email, password, Database.getUserCount());
		return newUser;
	}
	
	/**
	 * Promote user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public static User promoteUser(User user) {
		for(int i=0; i<userList.size(); i++){
			if((userList.get(i).getUsername().equals(user.getUsername()))&& (userList.get(i).getPassword().equals(user.getPassword()))){
				userList.get(i).setAdmin(true);
			}
		}
		return user;
	}
	
	/**
	 * Unlock user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public static User unlockUser(User user) {//cory
		for(int i=0; i<userList.size(); i++){
			if((userList.get(i).getUsername().equals(user.getUsername()))&& (userList.get(i).getPassword().equals(user.getPassword()))){
				userList.get(i).setLocked(false);
			}
		}
		return user;
	}
	
	/**
	 * Delete user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public static User deleteUser(User user) {
		return userList.remove(userList.indexOf(user));
	}
	
	/**
	 * Gets the password.
	 *
	 * @param email the email
	 * @return the password
	 */
	public static String getPassword(String email){
		for(int i=0; i<=userList.size(); i++){
			if(userList.get(i).getUsername().equals(email)){
				return userList.get(i).getPassword();
			}
		}
		return "";
	}
	
	/**
	 * Adds the item.
	 *
	 * @param item the item
	 * @return true, if successful
	 */
	public static boolean addItem(Item item){
		return getActiveUser().addItem(item);
	}
	
	/**
	 * Gets the user list.
	 *
	 * @return the user list
	 */
	public static ArrayList<User> getUserList() {
		return userList;
	}
	
	/**
	 * Make admin.
	 *
	 * @param oldUser the old user
	 */
	public static void makeAdmin(User oldUser){
		promoteUser(oldUser);
	}

	/**
	 * Gets the active user.
	 *
	 * @return the active user
	 */
	public static User getActiveUser() {
		return activeUser;
	}

	/**
	 * Sets the active user.
	 *
	 * @param user the new active user
	 */
	public static void setActiveUser(User user) {
		activeUser = user;
	}
	
	/**
	 * Filter.
	 *
	 * @param i the i
	 * @param filterCategory the filter category
	 * @param filterLostFound the filter lost found
	 * @param filterDate the filter date
	 * @param filterStatus the filter status
	 * @return true, if successful
	 */
	public static boolean filter(Item i, boolean[] filterCategory, int filterLostFound, long filterDate, boolean filterStatus){

		boolean toAdd = true;
		//fixed filgters based on new filter methods
		if (filterLostFound ==0){
			toAdd= false;
		}
		if (filterLostFound == 1 && !(i instanceof LostItem)) {
			toAdd = false;
		}
		if (filterLostFound == 2 && !(i instanceof FoundItem)) {
			toAdd = false;
		}
		if (!filterCategory[i.getCategory()]){
			toAdd= false;
		}
		if (i.getDate()<filterDate){
			toAdd = false;
		}
		if (i.isResolved() != filterStatus) {
			toAdd = false;
		}
		return (toAdd);
	}

	public static ArrayList<Item> getItemList() {
		return itemList;
	}

	public static void setItemList(ArrayList<Item> itemList) {
		WheresMyStuff.itemList = itemList;
	}
	
	public static DatabaseHelper getDatabase() {
		return Database;
	}

	public static void setDatabase(DatabaseHelper database) {
		Database = database;
	}
	public static void setUserList(ArrayList<User> userList) {
		WheresMyStuff.userList = userList;
	}

}
