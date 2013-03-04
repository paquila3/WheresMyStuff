package com.example.wheresmystuff;

abstract class Item {
	private String name, description;
	//super-constructor for all items.
	public Item(String name, String description){
		this.name=name;
		this.description=description;
	}

}
