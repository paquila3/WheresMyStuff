package com.example.wheresmystuff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class FoundItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_found_item);
		
		findViewById(R.id.submit).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						EditText nameText=(EditText)findViewById(R.id.found_name);
						String name=nameText.getText().toString();
						EditText descriptText=(EditText)findViewById(R.id.found_description);
						String description=descriptText.getText().toString();
						RadioButton keepsake= (RadioButton)findViewById(R.id.found_keepsake);
						RadioButton heirloom= (RadioButton)findViewById(R.id.found_heirloom);
						RadioButton picture= (RadioButton)findViewById(R.id.found_picture);
						RadioButton misc= (RadioButton)findViewById(R.id.found_misc);
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
						FoundItem found= new FoundItem(name, description, null,type);
						if(WheresMyStuff.addFound(found)){
							Intent foundIntent = new Intent(FoundItemActivity.this, ItemListActivity.class);
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.found_item, menu);
		return true;
	}

}
