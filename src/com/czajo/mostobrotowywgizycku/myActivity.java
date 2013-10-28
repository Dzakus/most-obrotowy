package com.czajo.mostobrotowywgizycku;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public abstract class myActivity extends Activity {
	
	@SuppressWarnings("unused")
	private static final String TAG = myActivity.class.getSimpleName();
	
	public static final int DLG_FIRST_START = 1;
	
	public static final String PREF_FIRST_START = "first_start";
	public static final String PREF_LAYOUT = "layout";
	
	public static final String PREFS_NAME = "MyPrefsFile1";
	
	public static final int LAYOUT_WODA = 1;
	public static final int LAYOUT_ZIEMIA = 2;



	protected SharedPreferences mPref;

	protected TextView czas, stan, miesiac;

	BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(Intent.ACTION_TIME_TICK)) {
				updateView();
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		czas = (TextView) findViewById(R.id.czas);
		stan = (TextView) findViewById(R.id.stan);
		
		mPref = getSharedPreferences(PREFS_NAME, 0);
		
		updateView();
		
	}

	public abstract void updateView();

	@SuppressWarnings("deprecation")
	@Override
	protected void onResume() {
		super.onResume();

		boolean firstStart = mPref.getBoolean(PREF_FIRST_START, false);
		if (firstStart)
			showDialog(DLG_FIRST_START);

		IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
		registerReceiver(mBroadcastReceiver, filter);

	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mBroadcastReceiver != null)
			unregisterReceiver(mBroadcastReceiver);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			Intent about = new Intent(this, About.class);
			startActivity(about);
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected Dialog onCreateDialog(int id) {

		switch (id) {
		case DLG_FIRST_START:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			LayoutInflater inlater = LayoutInflater.from(this);
			View eulaLayout = inlater.inflate(R.layout.checkbox, null);
			final CheckBox dontShowAgain = (CheckBox) eulaLayout
					.findViewById(R.id.skip);
			builder.setView(eulaLayout);
			builder.setTitle(R.string.dlg_first_start_title);
			builder.setMessage(R.string.dlg_first_start);
			builder.setPositiveButton(R.string.dlg_first_start_positive,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Editor editor = mPref.edit();
							editor.putBoolean(PREF_FIRST_START,
									dontShowAgain.isChecked());
							editor.commit();
							return;
						}
					});
			return builder.create();
		}
		return super.onCreateDialog(id);
	}
}
