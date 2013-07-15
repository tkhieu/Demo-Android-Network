package com.sss.demo.network;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceActivity extends Activity {

	ProgressBar progressBarService;
	TextView textViewProgressService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		final Intent intent = new Intent(getApplicationContext(),
				DownloadService.class);
		textViewProgressService = (TextView) findViewById(R.id.textViewProgressSerice);
		progressBarService = (ProgressBar) findViewById(R.id.progressBarService);
		Button buttonDownloadUsingService = (Button) findViewById(R.id.buttonDownloadUsingService);
		buttonDownloadUsingService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						DownloadService.class);
				intent.putExtra("url", "https://dl.dropboxusercontent.com/u/368693/com.facebook.orca.apk");
				intent.putExtra("receiver", new DownloadReceiver(new Handler()));
				startService(intent);
			}
		});
		Button buttonCancel = (Button) findViewById(R.id.buttonCancelService);
		buttonCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(intent);
				Toast.makeText(getApplicationContext(), "Stopping", Toast.LENGTH_LONG).show();
			}
		});

	}

	private class DownloadReceiver extends ResultReceiver {
		public DownloadReceiver(Handler handler) {
			super(handler);
		}

		@Override
		protected void onReceiveResult(int resultCode, Bundle resultData) {
			super.onReceiveResult(resultCode, resultData);
			if (resultCode == DownloadService.UPDATE_PROGRESS) {
				int progress = resultData.getInt("progress");
				progressBarService.setProgress(progress);
				textViewProgressService.setText(String.format("%d percent", progress));
			}
		}
	}
}
