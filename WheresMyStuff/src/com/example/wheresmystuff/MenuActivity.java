package com.example.wheresmystuff;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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
		
		findViewById(R.id.admin_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						if (!WheresMyStuff.getActiveUser().isAdmin())
							return;
						Intent adminIntent = new Intent(MenuActivity.this, AdminActivity.class);
						startActivity(adminIntent);
						finish();
					}
				});
		
		//added button to take it to item list so that we dont ahve to add items to get to it.
		findViewById(R.id.main_to_item_list).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View view) {
						if (!WheresMyStuff.getActiveUser().isAdmin())
							return;
						Intent itemListIntent = new Intent(MenuActivity.this, ItemListActivity.class);
						startActivity(itemListIntent);
						finish();
					}
				});
		
		//For future use, added a button to let them view user profiles.
		findViewById(R.id.main_user_profile).setOnClickListener(
				new View.OnClickListener(){

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						((Button) findViewById(R.id.main_user_profile)).setError(getString(R.string.DNE));
						
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
