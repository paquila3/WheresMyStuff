package com.example.wheresmystuff;

abstract class Item {
	private String name, description;
	//super-constructor for all items.
	public Item(String name, String description){
		this.setName(name);
		this.setDescription(description);
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
	
	public String toString()
	{
		return name;
	}

}
