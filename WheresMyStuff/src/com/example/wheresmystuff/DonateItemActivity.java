package com.example.wheresmystuff;

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
						String type="";
						try {
						if (healthcare.isChecked()){
							type="Healthcare";
						}
						else if(food.isChecked()){
							type="food";
						}
						else if(toys.isChecked()){
							type="Toys";
						}
						else if(clothing.isChecked()){
							type="Clothing";
						} else throw new Exception();
							} catch (Exception e) {
								Button submit= (Button) findViewById(R.id.submit);
								submit.setError(getString(R.string.error_select_type));
								View focusView = submit;
								focusView.requestFocus();
								e.printStackTrace();
							}
						DonateItem donate= new DonateItem(name, description, type, location);
						if(WheresMyStuff.add(donate)){
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

						Intent foundIntent = new Intent(DonateItemActivity.this, ItemListActivity.class);
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
