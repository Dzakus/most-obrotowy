package com.czajo.mostobrotowywgizycku;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class About extends Activity{
	
	private TextView tv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about); 
		tv = (TextView) findViewById(R.id.licencja);
		((TextView) findViewById(R.id.licencja)).setMovementMethod(LinkMovementMethod.getInstance());
		((TextView) findViewById(R.id.licencja)).setText(Html.fromHtml(getResources().getString(R.string.licencja))); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

}


