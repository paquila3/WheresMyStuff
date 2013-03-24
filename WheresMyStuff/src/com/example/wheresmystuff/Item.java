package com.example.wheresmystuff;

abstract class Item {
	private String name, description, category;
	private long date; //milliseconds since January 1, 1970
	private boolean resolved;
	//super-constructor for all items.
	public Item(String name, String description){
		this(name, description, 0, "");
	}
	
	public Item(String name, String description, long date){
		this(name, description, date, "");
	}
	
	public Item(String name, String description, long date, String category){
		this.setName(name);
		this.setDescription(description);
		this.setDate(date);
		this.setCategory(category);
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
	
	public void setDate(long date) {
		this.date = date;
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
