package com.example.wheresmystuff.model;

import com.example.wheresmystuff.presenter.WheresMyStuff;

public class DonateItem extends Item{
	//standard constructor
	//removed a lot of superfluous constructors. for donate i let the date be the date donated.
	public DonateItem(String name, String description, int category, String location) {
		super(name, description, category, location, WheresMyStuff.currentTime.getTimeInMillis());
	}

}
