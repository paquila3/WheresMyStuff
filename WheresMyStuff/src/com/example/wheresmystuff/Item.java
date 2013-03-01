package com.example.wheresmystuff;

import java.util.Date;

public class Item {
	protected String name, description, location, category, reward;
	protected User enteredBy;
	protected Date dateEntered;
	protected boolean resolved, lostItem;
	
	public Item(String name, String description, String location, String category, String reward, Date dateEntered, boolean lostItem) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.category = category;
		this.reward = reward;
		this.dateEntered = dateEntered;
		this.lostItem = lostItem;
	}
}
