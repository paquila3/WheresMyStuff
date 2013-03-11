package com.example.wheresmystuff;

import android.app.Application;
import java.util.ArrayList;

public class WheresMyStuff extends Application {
	private static ArrayList<User> userList = new ArrayList<User>();
	private static User activeUser;
	
	public static User createUser(String email, String password) {
		User newUser=new User(email, password);
		userList.add(newUser);
		return newUser;
	}
	
	static boolean add(Item item){
		return getActiveUser().add(item);
	}
	
	public static ArrayList<User> getUserList() {
		return userList;
	}
	
	/*public static getUser(User oldUser) {
		return userList.;
	}*/
	
	public static void makeAdmin(User oldUser){
		oldUser.setAdmin();
	}

	public static User getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(User user) {
		activeUser = user;
	}
}
