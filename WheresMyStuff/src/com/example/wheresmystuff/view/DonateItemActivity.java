package com.example.wheresmystuff.view;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.model.*;
import com.example.wheresmystuff.presenter.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class DonateItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate_item);
		
		findViewById(R.id.donate_confirm).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						EditText nameText=(EditText)findViewById(R.id.donate_name);
						String name=nameText.getText().toString();
						EditText descriptText=(EditText)findViewById(R.id.donate_description);
						String description=descriptText.getText().toString();
						EditText locationText= (EditText)findViewById(R.id.donate_location);
						String location= locationText.getText().toString();
						RadioButton healthcare= (RadioButton)findViewById(R.id.healthcare_radio);
						RadioButton food= (RadioButton)findViewById(R.id.food_radio);
						RadioButton toys= (RadioButton)findViewById(R.id.toys_radio);
						RadioButton clothing= (RadioButton)findViewById(R.id.clothing_radio);
						
						//changed the type labels to category, to be uniform with elsewhere.
						// also changed it to be an int so i can switch case it easily.
						// for donate it sets default to MISC just, in the even tehy dont check one.
						int category=Item.MISC;
						if (healthcare.isChecked()){
							category=Item.HEALTHCARE;
						}
						else if(food.isChecked()){
							category=Item.FOOD;
						}
						else if(toys.isChecked()){
							category=Item.TOYS;
						}
						else if(clothing.isChecked()){
							category=Item.CLOTHING;
						}
							
						DonateItem donate= new DonateItem(name, description, category, location);
						if(WheresMyStuff.addItem(donate)){
							Intent foundIntent = new Intent(DonateItemActivity.this, ItemListActivity.class);
							startActivity(foundIntent);
							finish();
						}
						else{
							Button submit= (Button) findViewById(R.id.submit);
							submit.setError(getString(R.string.error_try_again));
							View focusView = submit;
							focusView.requestFocus();
						}
					}
				});
		findViewById(R.id.back).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						Intent foundIntent = new Intent(DonateItemActivity.this, MenuActivity.class);
						startActivity(foundIntent);
						finish();
						
					}	
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.donate_item, menu);
		return true;
	}

}
