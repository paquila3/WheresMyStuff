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
import android.widget.TextView;


public class UserProfileActivity extends ListActivity {

	ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    boolean[] filterCategory = {true,true,true,true}; //keepsake, heirloom, picture, misc
    @SuppressWarnings("deprecation")
	long filterDate = (new Date(0,0,0)).getTime(); //changed to a long, initialized at Jan 1, 1900;
    int filterLostFound = 2; //0 = neither; 1 = lost only; 2 = found only 3=both. Changed for math reasons.
	boolean filterStatus = false; //false = open; true = resolved
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		final TextView textView = (TextView) findViewById(R.id.user_username);
		String name=WheresMyStuff.getActiveUser().getUsername();
		textView.setText(name);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		setListAdapter(adapter);
		populateList();
		
		findViewById(R.id.back).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent backIntent = new Intent(UserProfileActivity.this, MenuActivity.class);
						startActivity(backIntent);
						finish();
						
					}	
				});
		
		
	}

	protected void populateList() {
		User u = WheresMyStuff.getActiveUser();
			for (Item i : u.getItemList()){
				if (WheresMyStuff.filter(i, filterCategory, filterLostFound, filterDate, filterStatus)) {
					addItem(i.toString());
				}
			}
	}
	
	protected void addItem(String s){
		listItems.add(s);
        adapter.notifyDataSetChanged();
	}   
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_profile, menu);
		return true;
	}

}
