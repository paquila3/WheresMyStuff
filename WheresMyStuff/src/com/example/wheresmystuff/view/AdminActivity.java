package com.example.wheresmystuff.view;


import java.util.ArrayList;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.model.*;
import com.example.wheresmystuff.presenter.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminActivity.
 */
public class AdminActivity extends Activity { 

	/** The list items. */
	ArrayList<String> listItems = new ArrayList<String>();
    
    /** The adapter. */
    ArrayAdapter<String> adapter;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		ListView list = (ListView)findViewById(R.id.list_view_users);
		
		findViewById(R.id.Add_Admin).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						EditText edit =  (EditText) findViewById(R.id.user_email);
						String email=edit.getText().toString();
						String password=WheresMyStuff.getPassword(email);
						User clone = WheresMyStuff.createClone(email,password);
						WheresMyStuff.promoteUser(clone);
						Intent menuIntent = new Intent(AdminActivity.this, MenuActivity.class);
						startActivity(menuIntent);
						finish();
					}
				});
		
		findViewById(R.id.Unlock_User).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						EditText edit = (EditText) findViewById(R.id.user_email);
						String email = edit.getText().toString();
						User toDelete = null;
						for (User u : WheresMyStuff.getUserList()) {
							if (u.getUsername().equals(email)) {
								toDelete = u;
							}
						}
						if (toDelete != null) {
							WheresMyStuff.deleteUser(toDelete);
						}
						Intent menuIntent = new Intent(AdminActivity.this, MenuActivity.class);
						startActivity(menuIntent);
						finish();
					}
				});
		
		findViewById(R.id.Create_Admin).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						EditText edit =  (EditText) findViewById(R.id.user_email);
						String email=edit.getText().toString();
						String password=WheresMyStuff.getPassword(email);
						User clone = WheresMyStuff.createClone(email,password);
						WheresMyStuff.unlockUser(clone);
						Intent menuIntent = new Intent(AdminActivity.this, MenuActivity.class);
						startActivity(menuIntent);
						finish();
					}
				});
		
		findViewById(R.id.back).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent menuIntent = new Intent(AdminActivity.this, MenuActivity.class);
						startActivity(menuIntent);
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

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_admin, menu);
		return true;
	}
	
	/**
	 * Adds the user.
	 *
	 * @param s the s
	 */
	protected void addUser(String s)
	{
		listItems.add(s);
        adapter.notifyDataSetChanged();
	}

}
