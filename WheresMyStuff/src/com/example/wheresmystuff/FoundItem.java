package com.example.wheresmystuff;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class FoundItem extends Item{
	//Later create a constant bitmap for default to use instead of null.
	private Bitmap image;
	static Bitmap NO_IMAGE= BitmapFactory.decodeFile("/WheresMyStuff/no_image-web.png");
	//Constructor for if it has an image
	public FoundItem(String name, String description, Bitmap image) {
		super(name, description);
		this.setImage(image);
	}
	//other constructor
	public FoundItem(String name, String description){
		this(name,description,NO_IMAGE);
	}
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}

}
