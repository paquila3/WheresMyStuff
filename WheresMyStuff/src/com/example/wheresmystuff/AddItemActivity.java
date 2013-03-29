package com.example.wheresmystuff;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_item);
		
		((RadioButton)findViewById(R.id.lost_misc)).setChecked(true);
		
		findViewById(R.id.submit).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						EditText nameText=(EditText)findViewById(R.id.lost_name);
						String name=nameText.getText().toString();
						EditText descriptText=(EditText)findViewById(R.id.lost_description);
						String description=descriptText.getText().toString();
						EditText contactText=(EditText)findViewById(R.id.lost_contact_name);
						String contact=contactText.getText().toString();
						EditText phoneText=(EditText)findViewById(R.id.lost_phone_number);
						String phoneNumber=phoneText.getText().toString();
						EditText emailText=(EditText)findViewById(R.id.lost_email);
						String email=emailText.getText().toString();
						EditText locationText=(EditText)findViewById(R.id.lost_location);
						String location= locationText.getText().toString();
						RadioButton keepsake= (RadioButton)findViewById(R.id.lost_keepsake);
						RadioButton heirloom= (RadioButton)findViewById(R.id.lost_heirloom);
						RadioButton picture= (RadioButton)findViewById(R.id.lost_picture);
						//set default to Misc, and then only check 3 things. also changed name
						// to keep standardd with rest of files.
						int category=Item.MISC;
						if (keepsake.isChecked()){
							category=Item.KEEPSAKE;
						}
						else if(heirloom.isChecked()){
							category=Item.HEIRLOOM;
						}
						else if(picture.isChecked()){
							category=Item.PICTURE;
						}
						DatePicker datePicker= (DatePicker)findViewById(R.id.found_date);
						@SuppressWarnings("deprecation")
						Date d= new Date(datePicker.getYear()-1900, datePicker.getMonth(), datePicker.getDayOfMonth());;
						long date= d.getTime();
						LostItem lost= new LostItem(name, description, category, location, date, contact , phoneNumber, email);
						if(WheresMyStuff.add(lost)){
							Intent lostIntent = new Intent(AddItemActivity.this, ItemListActivity.class);
							lostIntent.putExtra("filter", "lost");
							startActivity(lostIntent);
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
						Intent lostIntent = new Intent(AddItemActivity.this, MenuActivity.class);
						startActivity(lostIntent);
						finish();
						
					}	
				});
		
		findViewById(R.id.lost_keepsake).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.lost_heirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.lost_picture)).setChecked(false);
						((RadioButton)findViewById(R.id.lost_misc)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.lost_heirloom).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.lost_keepsake)).setChecked(false);
						((RadioButton)findViewById(R.id.lost_picture)).setChecked(false);
						((RadioButton)findViewById(R.id.lost_misc)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.lost_picture).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.lost_heirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.lost_keepsake)).setChecked(false);
						((RadioButton)findViewById(R.id.lost_misc)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.lost_misc).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.lost_heirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.lost_picture)).setChecked(false);
						((RadioButton)findViewById(R.id.lost_keepsake)).setChecked(false);
						
					}	
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_item, menu);
		return true;
	}

}
