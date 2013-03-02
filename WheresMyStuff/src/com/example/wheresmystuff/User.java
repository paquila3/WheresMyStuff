package com.example.wheresmystuff;

public class User {
	private String username, password;
	private boolean admin, locked;
	
	public User(String username, String password) {
		this(username, password, false);
	}
	
	public User(String username, String password, boolean admin) {
		this.username = username;
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
	
	public boolean isAdmin() {
		return admin;
	}
	
	public boolean isLocked() {
		return locked;
	}
}
