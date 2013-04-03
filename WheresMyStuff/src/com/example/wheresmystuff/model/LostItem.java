package com.example.wheresmystuff.model;


// TODO: Auto-generated Javadoc
/**
 * The Class LostItem.
 */
public class LostItem extends Item{
	
	/** The email. */
	private String contact, number, email;
	//standard constructor

	//simplified, removed superfluous stuff.
	/**
	 * Instantiates a new lost item.
	 *
	 * @param name the name
	 * @param description the description
	 * @param category the category
	 * @param location the location
	 * @param date the date
	 * @param contact the contact
	 * @param number the number
	 * @param email the email
	 */
	public LostItem(String name, String description, int category, String location, long date, String contact, String number, String email) {
		super(name, description,category,location, date);
		this.contact=contact;
		this.number=number;
		this.email=email;
	}

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	
	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
