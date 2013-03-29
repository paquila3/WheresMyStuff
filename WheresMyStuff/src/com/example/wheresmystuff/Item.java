package com.example.wheresmystuff;

abstract class Item {
	private String name, description, location;
	//changed category to an int and set up some constants to use for this.
	private int category;
	public static final int KEEPSAKE=0,HEIRLOOM=1, PICTURE=2, MISC=3, CLOTHING=4, FOOD=5, HEALTHCARE=6, TOYS=7;
	private final long date; //milliseconds since January 1, 1970
	private boolean resolved=false;
	
	//super-constructor for all items.
	//changed to include, mostly, everything.
	public Item(String name, String description, int category, String location, long date){
		this.name=name;
		this.description=description;
		this.date=date;
		this.location=location;
		this.category=category;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return name;
	}
	
	public long getDate() {
		return date;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
