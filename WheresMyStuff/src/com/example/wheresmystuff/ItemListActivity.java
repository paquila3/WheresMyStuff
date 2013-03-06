package com.example.wheresmystuff;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItemListActivity extends ListActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		setListAdapter(adapter);
		
		for (User u : WheresMyStuff.getUserList())
		{
			for (Item i : u.getItemList())
			{
				addItem(i.toString());
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
