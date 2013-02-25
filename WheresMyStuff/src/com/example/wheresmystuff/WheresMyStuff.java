package com.example.wheresmystuff;

import android.app.Application;
import java.util.ArrayList;

public class WheresMyStuff extends Application {
	private static ArrayList<User> userList = new ArrayList<User>();
	
	public static void createUser(String email, String password) {
		userList.add(new User(email, password));
		System.out.println("User " + email + " created!");
	}
	
	public static ArrayList<User> getUserList() {
		return userList;
	}
}
