package com.example.wheresmystuff;

import android.app.Application;
import java.util.ArrayList;

public class WheresMyStuff extends Application {

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
	
	public static String getPassword(String email){
		for(int i=0; i<=userList.size(); i++){
			if(userList.get(i).getUsername().equals(email)){
				return userList.get(i).getPassword();
			}
		}
		return "";
	}
	
	static boolean add(Item item){
		return getActiveUser().add(item);
	}
	
	public static ArrayList<User> getUserList() {
		return userList;
	}
	
	public static void makeAdmin(User oldUser){//Cory-check this
		promoteUser(oldUser);
	}

	public static User getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(User user) {
		activeUser = user;
	}
}
