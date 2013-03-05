package com.example.wheresmystuff;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		findViewById(R.id.logout_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						WheresMyStuff.setActiveUser(null);
						Intent myIntent = new Intent(MenuActivity.this, LoginActivity.class);
						startActivity(myIntent);
						finish();
					}
				});
		
		findViewById(R.id.Found_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent foundIntent = new Intent(MenuActivity.this, FoundItemActivity.class);
						startActivity(foundIntent);
						finish();
					}
				});
		
		findViewById(R.id.lost_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent lostIntent = new Intent(MenuActivity.this, AddItemActivity.class);
						startActivity(lostIntent);
						finish();
					}
				});
		
		findViewById(R.id.Donate_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent donateIntent = new Intent(MenuActivity.this, DonateItemActivity.class);
						startActivity(donateIntent);
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
