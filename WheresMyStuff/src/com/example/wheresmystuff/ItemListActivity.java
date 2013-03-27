package com.example.wheresmystuff;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ItemListActivity extends ListActivity {

	private static final int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
	
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String filterCategory = "";
    int filterDate = 0; //0 = all time; 1 = today; 2 = last 7 days; 3 = last 30 days
    boolean filterStatus = false; //false = open; true = resolved
    public static String type = "all";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		setListAdapter(adapter);
		
		populateList();
		
		findViewById(R.id.buttonFlter).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						EditText etCategory = (EditText)findViewById(R.id.editTextCategory);
						RadioGroup rgDate = (RadioGroup)findViewById(R.id.radioGroupDate);
						CheckBox cbResolved = (CheckBox)findViewById(R.id.checkBoxResolved);
						
						filterCategory = etCategory.getText().toString();
						switch (rgDate.getCheckedRadioButtonId()) {
							case R.id.radioAll:
								filterDate = 0;
								break;
							case R.id.radioToday:
								filterDate = 1;
								break;
							case R.id.radioSevenDays:
								filterDate = 2;
								break;
							case R.id.radioThirtyDays:
								filterDate = 3;
								break;
						}
						filterStatus = cbResolved.isChecked();
						listItems.clear();
						adapter.notifyDataSetChanged();
						populateList();
					}
				});
		
	}
	
	protected void populateList() {
		// filter_type is either "lost" or "found"
		Intent intent = getIntent();
		String filter_type = intent.getStringExtra("filter");
		for (User u : WheresMyStuff.getUserList())
		{
			for (Item i : u.getItemList())
			{
				boolean toAdd = true;
				if ((filter_type == "found" && i instanceof LostItem) || (filter_type == "lost" && i instanceof FoundItem))
				{
					toAdd = false;
				}
				if ((type == "found" && i instanceof LostItem) || (type == "lost" && i instanceof FoundItem))
				{
					toAdd = false;
				}
				if (!filterCategory.equals("")) {
					if (!i.getCategory().equals(filterCategory)) {
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
