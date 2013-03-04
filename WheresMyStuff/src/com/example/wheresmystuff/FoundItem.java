package com.example.wheresmystuff;

import android.graphics.Bitmap;

public class FoundItem extends Item{
	//Later create a constant bitmap for default to use instead of null.
	Bitmap image;
	//Constructor for if it has an image
	public FoundItem(String name, String description, Bitmap image) {
		super(name, description);
		this.image=image;
	}
	//other constructor
	public FoundItem(String name, String description){
		this(name,description,null);
	}

}
