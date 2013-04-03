package com.example.wheresmystuff.view;

import java.util.Date;

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

// TODO: Auto-generated Javadoc
/**
 * The Class FoundItemActivity.
 */
public class FoundItemActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
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
						EditText datePicker= (EditText)findViewById(R.id.found_date);
						String dateString=datePicker.getText().toString();
						int month=1,day=1,year=0;
						if (dateString.charAt(2)=='/' && dateString.charAt(5)=='/' && dateString.length()==10){
							month=Integer.parseInt(dateString.substring(3, 5));
							day=Integer.parseInt(dateString.substring(0, 2));
							year=Integer.parseInt(dateString.substring(6,10));
						}
						else{
							Button submit= (Button) findViewById(R.id.submit);
							submit.setError(getString(R.string.error_try_again));
							View focusView = submit;
							focusView.requestFocus();
							return;
						}
						@SuppressWarnings("deprecation")
						Date d= new Date(year-1900, month-1, day);;
						long date= d.getTime();
						Item found= new FoundItem(name, description, category, location, date, WheresMyStuff.getActiveUser().getUserID(), WheresMyStuff.getItemList().size());
						if(WheresMyStuff.addItem(found)){

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

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.found_item, menu);
		return true;
	}

}
