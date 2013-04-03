package com.example.wheresmystuff.model;

import com.example.wheresmystuff.presenter.WheresMyStuff;

// TODO: Auto-generated Javadoc
/**
 * The Class DonateItem.
 */
public class DonateItem extends Item{
	//standard constructor
	//removed a lot of superfluous constructors. for donate i let the date be the date donated.
	/**
	 * Instantiates a new donate item.
	 *
	 * @param name the name
	 * @param description the description
	 * @param category the category
	 * @param location the location
	 */
	public DonateItem(String name, String description, int category, String location) {
		super(name, description, category, location, WheresMyStuff.currentTime.getTimeInMillis());
	}

}
