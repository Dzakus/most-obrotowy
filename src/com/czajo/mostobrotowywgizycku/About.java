package com.czajo.mostobrotowywgizycku;

import java.util.regex.Pattern;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
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


