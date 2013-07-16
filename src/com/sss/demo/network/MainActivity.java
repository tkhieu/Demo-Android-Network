package com.sss.demo.network;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button buttonVolleyActivity = (Button) findViewById(R.id.buttonVolleyActivity);
		buttonVolleyActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						VolleyActivity.class);
				startActivity(i);
			}
		});

		Button buttonAsyncTaskActivity = (Button) findViewById(R.id.buttonAsyncTaskActivity);
		buttonAsyncTaskActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						AsyncTaskActivity.class);
				startActivity(i);
			}
		});

		Button buttonServiceActivity = (Button) findViewById(R.id.buttonServiceActivity);
		buttonServiceActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						ServiceActivity.class);
				startActivity(i);
			}
		});
		
		Button buttonGroundyActivity = (Button) findViewById(R.id.buttonGroundyAcitivity);
		buttonGroundyActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), DownloadExample.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
