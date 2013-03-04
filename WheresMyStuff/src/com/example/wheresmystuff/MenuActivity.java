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
						Intent myIntent = new Intent(MenuActivity.this, LoginActivity.class);
						startActivity(myIntent);
						finish();
					}
				});
		
		findViewById(R.id.Found_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//Put your code here
						finish();
					}
				});
		
		findViewById(R.id.lost_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//Put your code here
						finish();
					}
				});
		
		findViewById(R.id.Donate_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//Put your code here
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
