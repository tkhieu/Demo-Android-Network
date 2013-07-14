package com.sss.demo.network;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class VolleyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_volley);
		
		Button buttonVolleyDownload = (Button) findViewById(R.id.buttonVolleyDownload);
		buttonVolleyDownload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				downloadFileFromDropbox();
			}
		});
	}

	protected void downloadFileFromDropbox() {
		// TODO Auto-generated method stub
		RequestQueue queue = Volley.newRequestQueue(this);

		String url = ""; 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.volley, menu);
		return true;
	}

}
