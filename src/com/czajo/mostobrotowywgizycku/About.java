package com.czajo.mostobrotowywgizycku;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class About extends Activity {

	private TextView mLicence;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		mLicence = (TextView) findViewById(R.id.licencja);
		mLicence.setMovementMethod(LinkMovementMethod.getInstance());
		Spanned text = Html.fromHtml(getResources().getString(R.string.licencja));
		mLicence.setText(text);
	}

}
