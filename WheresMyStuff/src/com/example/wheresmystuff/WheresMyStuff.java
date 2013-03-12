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
	
	public static User promoteUser(User user) {
		user.setAdmin(true);
		return user;
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
