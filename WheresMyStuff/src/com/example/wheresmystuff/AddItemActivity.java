package com.example.wheresmystuff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_item);
		
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
						LostItem lost= new LostItem(name, description, contact , phoneNumber, email);
						if(WheresMyStuff.add(lost)){
							Intent foundIntent = new Intent(AddItemActivity.this, ItemListActivity.class);
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

						Intent foundIntent = new Intent(AddItemActivity.this, MenuActivity.class);
						startActivity(foundIntent);
						finish();
						
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
