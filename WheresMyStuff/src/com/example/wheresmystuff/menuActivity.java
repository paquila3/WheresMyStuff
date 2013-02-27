package com.example.wheresmystuff;
import android.app.Activity;
import android.os.Bundle;
//import android.view.Menu;

public class menuActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_menu);
	}
	/**public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}**///Might need this for something but I'm not sure yet
}
