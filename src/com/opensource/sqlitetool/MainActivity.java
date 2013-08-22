package com.opensource.sqlitetool;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.opensource.sqlitetool.db.DBUtil;
import com.opensource.sqlitetool.util.AsyncDBTask;

public class MainActivity extends Activity {
	
	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new InsertTask().execute();
			}
		});
		
		findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new UpdateTask().execute();
			}
		});
		
		findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DeleteTask().execute();
			}
		});
	}
	
	
	private class InsertTask extends AsyncDBTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			DBUtil.insert(MainActivity.this, 50);
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			Log.i(TAG, "Insert complete");
		}
		
	}
	
	private class UpdateTask extends AsyncDBTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			DBUtil.udpate(MainActivity.this);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			Log.i(TAG, "Update complete");
		}
	}
	
	private class DeleteTask extends AsyncDBTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			DBUtil.delete(MainActivity.this);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			Log.i(TAG, "Delete complete");
		}
	}

}
