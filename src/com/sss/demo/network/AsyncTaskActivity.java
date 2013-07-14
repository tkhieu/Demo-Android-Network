package com.sss.demo.network;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncTaskActivity extends Activity {

	ProgressBar progressBar;
	TextView textViewProgress;
	DownloadFile dl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_task);
		dl = new DownloadFile();
		progressBar = (ProgressBar) findViewById(R.id.progressBarAsyncTask);
		textViewProgress = (TextView) findViewById(R.id.textViewProgress);
		Button buttonDownloadUsingAsyncTask = (Button) findViewById(R.id.buttonDownloadUsingAsyncTask);
		buttonDownloadUsingAsyncTask.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dl.execute("https://dl.dropboxusercontent.com/u/368693/com.facebook.orca.apk");
			}
		});

		Button buttonCancelAsyncTask = (Button) findViewById(R.id.buttonCancelAsyncTask);
		buttonCancelAsyncTask.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dl.cancel(true);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.async_task, menu);
		return true;
	}

	private class DownloadFile extends AsyncTask<String, Integer, String> {
		@Override
		protected String doInBackground(String... sUrl) {
			try {
				URL url = new URL(sUrl[0]);
				URLConnection connection = url.openConnection();
				connection.connect();
				// this will be useful so that you can show a typical 0-100%
				// progress bar
				int fileLength = connection.getContentLength();

				// download the file
				InputStream input = new BufferedInputStream(url.openStream());
				OutputStream output = new FileOutputStream(Environment
						.getExternalStorageDirectory().getPath()
						+ "/file_name.extension");

				byte data[] = new byte[1024];
				long total = 0;
				int count;
				while ((count = input.read(data)) != -1) {
					total += count;
					// publishing the progress....
					publishProgress((int) (total * 100 / fileLength));
					output.write(data, 0, count);
				}

				output.flush();
				output.close();
				input.close();
			} catch (Exception e) {
				Log.d("Error", e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onProgressUpdate(Integer... progress) {
			super.onProgressUpdate(progress);
			progressBar.setProgress(progress[0]);
			textViewProgress.setText(String.format("%d percent", progress[0]));
			if(isCancelled())
				textViewProgress.setText("Canceled by user");
		}
	}

}
