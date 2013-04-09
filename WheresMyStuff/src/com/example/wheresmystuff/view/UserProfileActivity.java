package com.example.wheresmystuff.view;

import java.util.ArrayList;

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

// TODO: Auto-generated Javadoc
/**
 * The Class UserProfileActivity.
 */

public class UserProfileActivity extends ListActivity {

	ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
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
				addItem(i.toString());
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
