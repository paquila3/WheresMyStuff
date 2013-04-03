package com.example.wheresmystuff.view;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.R.layout;
import com.example.wheresmystuff.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SearchMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_menu, menu);
		return true;
	}

}
