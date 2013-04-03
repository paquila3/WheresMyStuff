package com.example.wheresmystuff.view;

import java.util.ArrayList;
import java.util.Date;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.model.*;
import com.example.wheresmystuff.presenter.*;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ItemListActivity extends ListActivity {

	ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    //using a boolean array now because booleans work better for checkboxes
    boolean[] filterCategory = {true,true,true,true}; //keepsake, heirloom, picture, misc
    @SuppressWarnings("deprecation")
	long filterDate = (new Date(0,0,0)).getTime(); //changed to a long, initialized at Jan 1, 1900;
    int filterLostFound = 3; //0 = neither; 1 = lost only; 2 = found only 3=both. Changed for math reasons.
	boolean filterStatus = false; //false = open; true = resolved

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);

		((EditText)findViewById(R.id.list_date)).setText("01/01/1900");
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

						EditText datePicker= (EditText)findViewById(R.id.list_date);
						String dateString=datePicker.getText().toString();
						int month=1,day=1,year=0;
						if (dateString.charAt(2)=='/' && dateString.charAt(5)=='/' && dateString.length()==10){
							month=Integer.parseInt(dateString.substring(3, 5));
							day=Integer.parseInt(dateString.substring(0, 2));
							year=Integer.parseInt(dateString.substring(6,10));
						}
						else{
							Button submit= (Button) findViewById(R.id.buttonFlter);
							submit.setError(getString(R.string.error_try_again));
							View focusView = submit;
							focusView.requestFocus();
						}
						@SuppressWarnings("deprecation")
						Date d= new Date(year-1900, month-1, day);;
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
				if (WheresMyStuff.filter(i, filterCategory, filterLostFound, filterDate, filterStatus)) {
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