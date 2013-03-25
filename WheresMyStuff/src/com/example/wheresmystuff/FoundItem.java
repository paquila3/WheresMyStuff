package com.example.wheresmystuff;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class FoundItem extends Item{
	//Later create a constant bitmap for default to use instead of null.
	private Bitmap image;
	static Bitmap NO_IMAGE= BitmapFactory.decodeFile("/WheresMyStuff/no_image-web.png");
	//Constructor for if it has an image
	public FoundItem(String name, String description, Bitmap image, String type) {
		this(name, description, image, type, 0);
	}
	public FoundItem(String name, String description, Bitmap image, String type, long date) {
		super(name, description);
		this.setImage(image);
		this.setCategory(type);
		this.setDate(date);
	}
	//other constructor
	public FoundItem(String name, String description, String type){
		this(name,description,NO_IMAGE, type);
	}
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}

}
