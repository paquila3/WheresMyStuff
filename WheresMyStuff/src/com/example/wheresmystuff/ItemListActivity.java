package com.example.wheresmystuff;

import java.util.ArrayList;
import java.util.Date;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;

public class ItemListActivity extends ListActivity {

	ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    //using a boolean array now because booleans work better for checkboxes
    boolean[] filterCategory = {true,true,true,true}; //keepsake, heirloom, picture, misc
    @SuppressWarnings("deprecation")
	long filterDate = (new Date(0,0,1)).getTime(); //changed to a long, initialized at Jan 1, 1900;
    int filterLostFound = 0; //0 = neither; 1 = lost only; 2 = found only 3=both. Changed for math reasons.
	boolean filterStatus = false; //false = open; true = resolved

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		setListAdapter(adapter);
		
		((CheckBox)findViewById(R.id.list_lost)).setChecked(true);
		((CheckBox)findViewById(R.id.list_found)).setChecked(true);
		
		populateList();
		
		findViewById(R.id.buttonFlter).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//changed all of them to checkboxes, removed the ones i deleted, added the date getter.
						CheckBox cbKeepsake = (CheckBox)findViewById(R.id.checkKeepsake);
						CheckBox cbHeirloom = (CheckBox)findViewById(R.id.checkHeirloom);
						CheckBox cbPicture = (CheckBox)findViewById(R.id.checkPicture);
						CheckBox cbMisc = (CheckBox)findViewById(R.id.checkMisc);
						CheckBox cbResolved = (CheckBox)findViewById(R.id.checkResolved);
						CheckBox cbLost= (CheckBox)findViewById(R.id.list_lost);
						CheckBox cbFound= (CheckBox)findViewById(R.id.list_found);
						//redid the filtercategory in terms of the booleans
						if (cbKeepsake.isChecked()) {
							filterCategory[0]=true;
						}
						else{
							filterCategory[0]=false;
						}
						if (cbHeirloom.isChecked()) {
							filterCategory[1]=true;
						}
						else{
							filterCategory[1]=false;
						}
						if (cbPicture.isChecked()) {
							filterCategory[2]=true;
						}
						else{
							filterCategory[2]=false;
						}
						if (cbMisc.isChecked()) {
							filterCategory[3]=true;
						}
						else{
							filterCategory[3]=false;
						}
						
						//math is a beautiful thing, isn't it?
						filterLostFound=0;
						if (cbLost.isChecked()){
							filterLostFound+=1;
						}
						if (cbFound.isChecked()){
							filterLostFound+=2;
						}
						
						DatePicker datePicker= (DatePicker)findViewById(R.id.list_date_picker);
						@SuppressWarnings("deprecation")
						Date d= new Date(datePicker.getYear()-1900, datePicker.getMonth(), datePicker.getDayOfMonth());
						filterDate = d.getTime();
						
						filterStatus = cbResolved.isChecked();
						listItems.clear();
						adapter.notifyDataSetChanged();
						populateList();
					}
				});
		findViewById(R.id.back).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						Intent foundIntent = new Intent(ItemListActivity.this, MenuActivity.class);
						startActivity(foundIntent);
						finish();
						
					}	
				});
	}
	
	protected void populateList() {
		for (User u : WheresMyStuff.getUserList())
		{
			for (Item i : u.getItemList())
			{
				boolean toAdd = true;
				//fixed filgters based on new filter methods
				if (filterLostFound ==0){
					toAdd= false;
				}
				if (filterLostFound == 1 && !(i instanceof LostItem)) {
					toAdd = false;
				}
				if (filterLostFound == 2 && !(i instanceof FoundItem)) {
					toAdd = false;
				}
				if (!filterCategory[i.getCategory()]){
					toAdd= false;
				}
				if (i.getDate()<filterDate){
					toAdd = false;
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


    public void setFilterCategory(boolean[] filterCategory) {
		this.filterCategory = filterCategory;
	}

	public void setFilterDate(long filterDate) {
		this.filterDate = filterDate;
	}

	public void setFilterLostFound(int filterLostFound) {
		this.filterLostFound = filterLostFound;
	}

	public void setFilterStatus(boolean filterStatus) {
		this.filterStatus = filterStatus;
	}


}