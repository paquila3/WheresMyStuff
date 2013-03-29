package com.example.wheresmystuff;

public class LostItem extends Item{
	private String contact, number, email;
	//standard constructor

	//simplified, removed superfluous stuff.
	public LostItem(String name, String description, int category, String location, long date, String contact, String number, String email) {
		super(name, description,category,location, date);
		this.contact=contact;
		this.number=number;
		this.email=email;
	}

	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
