package com.example.wheresmystuff;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class AdminActivity extends Activity { 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}

}
