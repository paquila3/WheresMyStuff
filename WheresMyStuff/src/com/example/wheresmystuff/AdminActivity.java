package com.example.wheresmystuff;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AdminActivity extends Activity { 

	ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		ListView list = (ListView)findViewById(R.id.list_view_users);
		
		findViewById(R.id.Add_Admin).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//Cory
						finish();
					}
				});
		
		findViewById(R.id.Create_Admin).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//Your work here
						finish();
					}
				});
		
		findViewById(R.id.Unlock_User).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//Your work here
						finish();
					}
				});
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		list.setAdapter(adapter);
		
		for (User u : WheresMyStuff.getUserList())
		{
			addUser(u.toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_admin, menu);
		return true;
	}
	
	protected void addUser(String s)
	{
		listItems.add(s);
        adapter.notifyDataSetChanged();
	}

}
