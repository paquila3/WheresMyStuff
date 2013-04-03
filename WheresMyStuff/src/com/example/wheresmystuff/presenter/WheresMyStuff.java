package com.example.wheresmystuff.presenter;

import java.util.Calendar;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Application;
import java.util.ArrayList;

import com.example.wheresmystuff.model.FoundItem;
import com.example.wheresmystuff.model.Item;
import com.example.wheresmystuff.model.LostItem;
import com.example.wheresmystuff.model.User;

public class WheresMyStuff extends Application {

	public static Calendar currentTime = Calendar.getInstance();
	
	private static ArrayList<User> userList = new ArrayList<User>();
	private static User activeUser;
	private static boolean init;
	
	public static void initialize() {
		if (init)
			return;
		User adm = WheresMyStuff.createUser("a@m","aaaa");
		WheresMyStuff.promoteUser(adm);//Creates default admin
		init = true;
	}
	
	public static User createUser(String email, String password) {
		User newUser=new User(email, password);
		userList.add(newUser);
		return newUser;
	}
	
	public static User createClone(String email, String password) {//cory
		User newUser=new User(email, password);
		return newUser;
	}
	
	public static User promoteUser(User user) {
		for(int i=0; i<userList.size(); i++){
			if((userList.get(i).getUsername().equals(user.getUsername()))&& (userList.get(i).getPassword().equals(user.getPassword()))){
				userList.get(i).setAdmin(true);
			}
		}
		return user;
	}
	
	public static User unlockUser(User user) {//cory
		for(int i=0; i<userList.size(); i++){
			if((userList.get(i).getUsername().equals(user.getUsername()))&& (userList.get(i).getPassword().equals(user.getPassword()))){
				userList.get(i).setLocked(false);
			}
		}
		return user;
	}
	
	public static User deleteUser(User user) {
		return userList.remove(userList.indexOf(user));
	}
	
	public static String getPassword(String email){
		for(int i=0; i<=userList.size(); i++){
			if(userList.get(i).getUsername().equals(email)){
				return userList.get(i).getPassword();
			}
		}
		return "";
	}
	
	public static boolean addItem(Item item){
		return getActiveUser().addItem(item);
	}
	
	public static ArrayList<User> getUserList() {
		return userList;
	}
	
	public static void makeAdmin(User oldUser){
		promoteUser(oldUser);
	}

	public static User getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(User user) {
		activeUser = user;
	}
	
	@SuppressLint("DefaultLocale")
	public static boolean search(Item i, String name, String description) {
		int required = 0, have = 0;
		if (name != "") {
			required++;
		}
		if (description != "") {
			required++;
		}
		if (i.getName().toLowerCase(Locale.ENGLISH).equals(name.toLowerCase(Locale.ENGLISH)) && name != "") {
			have++;
		}
		if (i.getDescription().toLowerCase(Locale.ENGLISH).equals(description.toLowerCase(Locale.ENGLISH)) && description != "") {
			have++;
		}
		if (have >= required && required > 0) {
			return true;
		}
		return false;
	}
	
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
}
