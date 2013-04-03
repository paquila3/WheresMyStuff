package com.example.wheresmystuff.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
public abstract class Item {
	
	/** The location. */
	private String name, description, location;
	//changed category to an int and set up some constants to use for this.
	/** The category. */
	private int category;
	
	/** The Constant TOYS. */
	public static final int KEEPSAKE=0,HEIRLOOM=1, PICTURE=2, MISC=3, CLOTHING=4, FOOD=5, HEALTHCARE=6, TOYS=7;
	
	/** The date. */
	private final long date; //milliseconds since January 1, 1970
	
	/** The resolved. */
	private boolean resolved=false;
	
	//super-constructor for all items.
	//changed to include, mostly, everything.
	/**
	 * Instantiates a new item.
	 *
	 * @param name the name
	 * @param description the description
	 * @param category the category
	 * @param location the location
	 * @param date the date
	 */
	public Item(String name, String description, int category, String location, long date){
		this.name=name;
		this.description=description;
		this.date=date;
		this.location=location;
		this.category=category;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public long getDate() {
		return date;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * Checks if is resolved.
	 *
	 * @return true, if is resolved
	 */
	public boolean isResolved() {
		return resolved;
	}

	/**
	 * Sets the resolved.
	 *
	 * @param resolved the new resolved
	 */
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
