package com.example.wheresmystuff.model;


// TODO: Auto-generated Javadoc
/**
 * The Class FoundItem.
 */
public class FoundItem extends Item{
	//Constructor for if it has an image
	//removed superfluous constructors, simplified.
	/**
	 * Instantiates a new found item.
	 *
	 * @param name the name
	 * @param description the description
	 * @param category the category
	 * @param location the location
	 * @param date the date
	 */
	public FoundItem(String name, String description, int category, String location, long date, int userID, int ID) {
		super(name, description, category, location, date, userID, ID);
	}
}
