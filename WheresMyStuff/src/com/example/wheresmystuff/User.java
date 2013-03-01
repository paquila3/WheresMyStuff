package com.example.wheresmystuff;

import android.annotation.SuppressLint;

public class User {
	private String username, password;
	private boolean admin, locked;
	
	public User(String username, String password) {
		this(username, password, false);
	}
	
	@SuppressLint("DefaultLocale")
	public User(String username, String password, boolean admin) {
		this.username = username.toLowerCase();
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
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public boolean isLocked() {
		return locked;
	}
}
