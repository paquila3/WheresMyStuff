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

public class FoundItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_found_item);
		((RadioButton)findViewById(R.id.found_misc)).setChecked(true);
		
		findViewById(R.id.submit).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						EditText nameText=(EditText)findViewById(R.id.found_name);
						String name=nameText.getText().toString();
						EditText descriptText=(EditText)findViewById(R.id.found_description);
						String description=descriptText.getText().toString();
						EditText locationText=(EditText)findViewById(R.id.found_location);
						String location=locationText.getText().toString();
						RadioButton keepsake= (RadioButton)findViewById(R.id.found_keepsake);
						RadioButton heirloom= (RadioButton)findViewById(R.id.found_heirloom);
						RadioButton picture= (RadioButton)findViewById(R.id.found_picture);

						//default status is misc, change name for uniformity.
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
						Item found= new FoundItem(name, description, category, location, date);
						if(WheresMyStuff.add(found)){
							Intent foundIntent = new Intent(FoundItemActivity.this, ItemListActivity.class);

							foundIntent.putExtra("filter", "found");
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
						Intent foundIntent = new Intent(FoundItemActivity.this, MenuActivity.class);
						startActivity(foundIntent);
						finish();
						
					}	
				});
		
		findViewById(R.id.found_keepsake).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.found_heirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.found_picture)).setChecked(false);
						((RadioButton)findViewById(R.id.found_misc)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.found_heirloom).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.found_keepsake)).setChecked(false);
						((RadioButton)findViewById(R.id.found_picture)).setChecked(false);
						((RadioButton)findViewById(R.id.found_misc)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.found_picture).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.found_heirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.found_keepsake)).setChecked(false);
						((RadioButton)findViewById(R.id.found_misc)).setChecked(false);
						
					}	
				});
		
		findViewById(R.id.found_misc).setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {

						((RadioButton)findViewById(R.id.found_heirloom)).setChecked(false);
						((RadioButton)findViewById(R.id.found_picture)).setChecked(false);
						((RadioButton)findViewById(R.id.found_keepsake)).setChecked(false);
						
					}	
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.found_item, menu);
		return true;
	}

}
