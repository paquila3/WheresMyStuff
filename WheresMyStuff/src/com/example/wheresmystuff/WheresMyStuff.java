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
	
	public static User createAdmin(String email, String password) {
		User newUser=new User(email, password,true);
		userList.add(newUser);
		return newUser;
	}
	
	static boolean add(Item item){
		return getActiveUser().add(item);
	}
	
	public static ArrayList<User> getUserList() {
		return userList;
	}
	
	public static void makeAdmin(User oldUser){//Cory-check this
		String username=oldUser.getUsername();
		String password=oldUser.getPassword();
		userList.remove(oldUser);
		createAdmin(username,password);
	}

	public static User getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(User user) {
		activeUser = user;
	}
}
