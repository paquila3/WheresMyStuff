package com.example.wheresmystuff;

public class LostItem extends Item{
	private String contact, number, email;
	//standard constructor
	public LostItem(String name, String description, String contact, String number, String email) {
		this(name, description, contact, number, email, 0);
	}
	
	public LostItem(String name, String description, String contact, String number, String email, long date) {
		super(name, description, date);
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
