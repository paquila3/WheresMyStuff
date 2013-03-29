package com.example.wheresmystuff;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
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
						EditText datePicker= (EditText)findViewById(R.id.found_date);
						String dateString=datePicker.getText().toString();
						int month=1,day=1,year=1;
						if (dateString.charAt(2)=='/' && dateString.charAt(4)=='/' && dateString.length()==10){
							month=Integer.parseInt(dateString.substring(3, 5));
							day=Integer.parseInt(dateString.substring(0, 2));
							year=Integer.parseInt(dateString.substring(6,10));
						}
						else{
							Button submit= (Button) findViewById(R.id.submit);
							submit.setError(getString(R.string.error_try_again));
							View focusView = submit;
							focusView.requestFocus();
						}
						@SuppressWarnings("deprecation")
						Date d= new Date(year-1900, month-1, day);;
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
