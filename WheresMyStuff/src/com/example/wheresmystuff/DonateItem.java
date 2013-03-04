package com.example.wheresmystuff;

public class DonateItem extends Item{
	String type, location;
	//standard constructor
	public DonateItem(String name, String description, String type, String location) {
		super(name, description);
		this.type=type;
		this.location=location;
	}

}
