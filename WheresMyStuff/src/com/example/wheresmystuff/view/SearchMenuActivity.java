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
 * The Class SearchMenuActivity.
 */
public class SearchMenuActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
	private static String filterName, filterDescription, matchName, matchDescription;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_menu);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		ListView list = (ListView)findViewById(R.id.search_list);
		list.setAdapter(adapter);
		if (matchName != null && matchName != "") {
			filterName = matchName;
			matchName = "";
		} else {
			filterName = "";
		}
		if (matchDescription != null && matchDescription != "") {
			filterDescription = matchDescription;
			matchDescription = "";
		} else {
			filterDescription = "";
		}
		
		populateList();
		
		findViewById(R.id.search).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						EditText tbName = (EditText)findViewById(R.id.search_name);
						EditText tbDescription = (EditText)findViewById(R.id.search_description);
						filterName = tbName.getText().length() > 0 ? tbName.getText().toString() : "";
						filterDescription = tbDescription.getText().length() > 0 ? tbDescription.getText().toString() : "";
						
						listItems.clear();
						adapter.notifyDataSetChanged();
						populateList();
					}
				});
		
		findViewById(R.id.search_back).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						Intent foundIntent = new Intent(SearchMenuActivity.this, MenuActivity.class);
						startActivity(foundIntent);
						finish();
						
					}	
				});
		
	}
	
	protected void populateList() {
		String add;
		for (Item i : WheresMyStuff.getItemList())
		{
			if (WheresMyStuff.search(i, filterName, filterDescription)) {
				add = i.toString();
				if (i instanceof LostItem) {
					add += " (Lost)";
				}
				if (i instanceof FoundItem) {
					add += " (Found)";
				}
				addItem(add);
			}
		}
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	protected void addItem(String s)
	{
		listItems.add(s);
        adapter.notifyDataSetChanged();
	}
	
	public static void setMatchDetails(String name, String description) {
		matchName = name;
		matchDescription = description;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_menu, menu);
		return true;
	}

}
