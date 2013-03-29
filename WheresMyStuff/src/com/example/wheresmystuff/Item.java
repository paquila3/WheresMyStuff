package com.example.wheresmystuff;

abstract class Item {
	private String name, description, category;
	private final long date; //milliseconds since January 1, 1970
	private boolean resolved;
	//super-constructor for all items.
	
	public Item(String name, String description){
		this(name, description, "");
	}
	
	public Item(String name, String description, String category){
		this.name=name;
		this.description=(description);
		this.date=WheresMyStuff.currentTime.getTimeInMillis();
		this.category=category;
		setResolved(false);
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

}
