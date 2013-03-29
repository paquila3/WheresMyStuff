package com.example.wheresmystuff;

public class LostItem extends Item{
	private String contact, number, email, type;
	//standard constructor

	
	public LostItem(String name, String description, String contact, String number, String email, String type) {
		super(name, description,type);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
