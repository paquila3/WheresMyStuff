package com.example.wheresmystuff;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class ItemListActivity extends ListActivity {

	private static final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
	
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String filterCategory = "";
    int filterDate = 0; //0 = all time; 1 = today; 2 = last 7 days; 3 = last 30 days
    int filterLostFound = 0; //0 = both; 1 = lost only; 2 = found only
    boolean filterStatus = false; //false = open; true = resolved

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		setListAdapter(adapter);
		
		((RadioButton)findViewById(R.id.radioAllCategory)).setChecked(true);
		((RadioButton)findViewById(R.id.radioAll)).setChecked(true);
		
		populateList();
		
		findViewById(R.id.buttonFlter).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						RadioButton rbKeepsake = (RadioButton)findViewById(R.id.radioKeepsake);
						RadioButton rbHeirloom = (RadioButton)findViewById(R.id.radioHeirloom);
						RadioButton rbPicture = (RadioButton)findViewById(R.id.radioPicture);
						RadioButton rbMisc = (RadioButton)findViewById(R.id.radioMisc);
						RadioButton rbToday = (RadioButton)findViewById(R.id.radioToday);
						RadioButton rbSevenDays = (RadioButton)findViewById(R.id.radioSevenDays);
						RadioButton rbThirtyDays = (RadioButton)findViewById(R.id.radioThirtyDays);
						CheckBox cbResolved = (CheckBox)findViewById(R.id.checkBoxResolved);
						
						filterCategory = "";
						if (rbKeepsake.isChecked()) {
							filterCategory = "Keepsake";
						} else if (rbHeirloom.isChecked()) {
							filterCategory = "Heirloom";
						} else if (rbPicture.isChecked()) {
							filterCategory = "Picture";
						} else if (rbMisc.isChecked()) {
							filterCategory = "Misc";
						}
						filterDate = 0;
						if (rbToday.isChecked()) {
							filterDate = 1;
						} else if (rbSevenDays.isChecked()) {
							filterDate = 2;
						} else if (rbThirtyDays.isChecked()) {
							filterDate = 3;
						}
						filterStatus = cbResolved.isChecked();
						listItems.clear();
						adapter.notifyDataSetChanged();
						populateList();
					}
				});
		
		findViewById(R.id.radioKeepsake).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioHeirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.radioPicture)).setChecked(false);
						((RadioButton)findViewById(R.id.radioMisc)).setChecked(false);
						((RadioButton)findViewById(R.id.radioAllCategory)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.radioHeirloom).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioKeepsake)).setChecked(false);
						((RadioButton)findViewById(R.id.radioPicture)).setChecked(false);
						((RadioButton)findViewById(R.id.radioMisc)).setChecked(false);
						((RadioButton)findViewById(R.id.radioAllCategory)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.radioPicture).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioHeirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.radioMisc)).setChecked(false);
						((RadioButton)findViewById(R.id.radioKeepsake)).setChecked(false);
						((RadioButton)findViewById(R.id.radioAllCategory)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.radioMisc).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioHeirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.radioPicture)).setChecked(false);
						((RadioButton)findViewById(R.id.radioKeepsake)).setChecked(false);
						((RadioButton)findViewById(R.id.radioAllCategory)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.radioAllCategory).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioHeirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.radioPicture)).setChecked(false);
						((RadioButton)findViewById(R.id.radioMisc)).setChecked(false);
						((RadioButton)findViewById(R.id.radioKeepsake)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.radioAll).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioToday)).setChecked(false);
						((RadioButton)findViewById(R.id.radioSevenDays)).setChecked(false);
						((RadioButton)findViewById(R.id.radioThirtyDays)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.radioToday).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioAll)).setChecked(false);
						((RadioButton)findViewById(R.id.radioSevenDays)).setChecked(false);
						((RadioButton)findViewById(R.id.radioThirtyDays)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.radioSevenDays).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioToday)).setChecked(false);
						((RadioButton)findViewById(R.id.radioAll)).setChecked(false);
						((RadioButton)findViewById(R.id.radioThirtyDays)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.radioThirtyDays).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.radioToday)).setChecked(false);
						((RadioButton)findViewById(R.id.radioSevenDays)).setChecked(false);
						((RadioButton)findViewById(R.id.radioAll)).setChecked(false);
						
					}	
				});
		
	}
	
	protected void populateList() {
		for (User u : WheresMyStuff.getUserList())
		{
			for (Item i : u.getItemList())
			{
				boolean toAdd = true;
				if (filterLostFound == 1 && !(i instanceof LostItem)) {
					toAdd = false;
				}
				if (filterLostFound == 2 && !(i instanceof FoundItem)) {
					toAdd = false;
				}
				if (!filterCategory.equals("")) {
					if (!(i.getCategory().equals(filterCategory))) {
						toAdd = false;
					}
				}
				if (filterDate != 0) {
					if (i.getDate() == 0) {
						toAdd = false;
					} else {
						switch (filterDate) {
							case 1:
								if (WheresMyStuff.currentTime.getTimeInMillis() - i.getDate() > MILLIS_IN_DAY) {
									toAdd = false;
								}
								break;
							case 2:
								if (WheresMyStuff.currentTime.getTimeInMillis() - i.getDate() > MILLIS_IN_DAY * 7) {
									toAdd = false;
								}
								break;
							case 3:
								if (WheresMyStuff.currentTime.getTimeInMillis() - i.getDate() > MILLIS_IN_DAY * 30) {
									toAdd = false;
								}
								break;
						}
					}
				}
				if (i.isResolved() != filterStatus) {
					toAdd = false;
				}
				if (toAdd) {
					addItem(i.toString());
				}
			}
		}
	}
	
	protected void addItem(String s)
	{
		listItems.add(s);
        adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_list, menu);
		return true;
	}
	
	

}
