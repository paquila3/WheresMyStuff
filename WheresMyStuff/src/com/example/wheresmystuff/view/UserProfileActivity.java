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
import android.widget.ListView;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class UserProfileActivity.
 */

public class UserProfileActivity extends Activity {

	ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		
		final TextView textView = (TextView) findViewById(R.id.user_username);
		String name=WheresMyStuff.getActiveUser().getUsername();
		textView.setText(name);
		
		final TextView textView2 = (TextView) findViewById(R.id.is_admin);
		String name2;
		if(WheresMyStuff.getActiveUser().isAdmin()){
			name2="Admin Account";
		}
		else{
			name2="Regular Account";
		}
		textView2.setText(name2);
		
		final TextView textView3 = (TextView) findViewById(R.id.items_text);
		textView3.setText("Items:");
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		ListView list = (ListView)findViewById(R.id.user_list);
		list.setAdapter(adapter);
		
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
		String add;
			for (Item i : u.getItemList()){
				add=i.toString();
				addItem(add);
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
