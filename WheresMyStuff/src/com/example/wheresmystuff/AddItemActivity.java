package com.example.wheresmystuff;

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
						RadioButton keepsake= (RadioButton)findViewById(R.id.lost_keepsake);
						RadioButton heirloom= (RadioButton)findViewById(R.id.lost_heirloom);
						RadioButton picture= (RadioButton)findViewById(R.id.lost_picture);
						RadioButton misc= (RadioButton)findViewById(R.id.lost_misc);
						String type="";
						if (keepsake.isChecked()){
							type="Keepsake";
						}
						else if(heirloom.isChecked()){
							type="Heirloom";
						}
						else if(picture.isChecked()){
							type="Picture";
						}
						else if(misc.isChecked()){
							type="Misc";
						}
						LostItem lost= new LostItem(name, description, contact , phoneNumber, email, type);
						if(WheresMyStuff.add(lost)){
							ItemListActivity.setLostFoundFilter(1);
							Intent lostIntent = new Intent(AddItemActivity.this, ItemListActivity.class);
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
