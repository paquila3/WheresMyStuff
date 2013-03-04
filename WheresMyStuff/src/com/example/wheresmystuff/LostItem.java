package com.example.wheresmystuff;

public class LostItem extends Item{
	private String contact, number, email;
	//standard constructor
	public LostItem(String name, String description, String contact, String number, String email) {
		super(name, description);
		this.contact=contact;
		this.number=number;
		this.email=email;
	}

}
