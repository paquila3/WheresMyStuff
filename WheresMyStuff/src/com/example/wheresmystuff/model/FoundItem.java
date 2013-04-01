package com.example.wheresmystuff.model;


public class FoundItem extends Item{
	//Constructor for if it has an image
	//removed superfluous constructors, simplified.
	public FoundItem(String name, String description, int category, String location, long date) {
		super(name, description, category, location, date);
	}
}
