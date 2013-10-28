package com.czajo.mostobrotowywgizycku;

import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

public class Wodna extends myActivity {

	private static final int DLG_MOPR = DLG_FIRST_START+1;

	public void updateView() {
		Calendar c = Calendar.getInstance();
		int min = c.get(Calendar.MINUTE);
		int hours = c.get(Calendar.HOUR_OF_DAY);
		int day = c.get(Calendar.DAY_OF_YEAR);
		int wynik = (hours * 60) + min;
		int minuty;
		// 28 kwietnia do 6 maja i od 1 czerwca do 16 wrzeœnia
		if ((day >= 118 && day <= 126) || (day >= 152 && day <= 259))

		{
			// MOST OTWARTY DLA RUCHU WODNEGO
			if (hours == 0 || hours == 1 || hours == 2 || hours == 3
					|| hours == 4 || hours == 5 || hours == 6 || hours == 7) {
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
			}

			if (wynik >= 490 && wynik <= 510) // 8.10 - 8.30
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 510 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 635 && wynik <= 660) // 10.35 - 11.00
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 660 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 750 && wynik <= 780) // 12.30 - 13.00
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 780 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 825 && wynik <= 885) // 13.45 - 14.45
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 885 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 950 && wynik <= 1040) // 15.50 - 17.20
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 1040 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 1110 && wynik <= 1140) // 18.30 - 19.00
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 1140 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			// MOST ZAMKNIÊTY DLA RUCHU WODNEGO
			if (wynik >= 511 && wynik <= 634) // 8.31 - 10.34
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 634 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 661 && wynik <= 749) // 11.01 - 12.29
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 749 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 781 && wynik <= 824) // 13.01 - 13.44
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 824 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 886 && wynik <= 949) // 14.46 - 15.49
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 949 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 1041 && wynik <= 1109) // 17.21 - 18.29
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 1109 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 1141) // 19.01
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");

			}
		}
		// 1 do 27 kwietnia, od 7 do 31 maja oraz od 17 wrzeœnia do 31 paŸdziernika
		if ((day >= 91 && day <= 117) || (day >= 127 && day <= 151)
				|| (day >= 260 && day <= 304)) {
			// MOST OTWARTY DLA RUCHU WODNEGO
			if (hours == 0 || hours == 1 || hours == 2 || hours == 3
					|| hours == 4 || hours == 5 || hours == 6 || hours == 7
					|| hours == 8 || hours == 9) {
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
			}

			if (wynik >= 635 && wynik <= 660) // 10.35 - 11.00
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 660 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 750 && wynik <= 780) // 12.30 - 13.00
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 780 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 825 && wynik <= 885) // 13.45 - 14.45
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 885 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 950) // 15.50 - 17.20
			{
				czas.setTextColor(Color.GREEN);
				czas.setText("OTWARTY");
				minuty = 1040 - wynik;
			}

			// MOST ZAMKNIÊTY DLA RUCHU WODNEGO
			if (wynik >= 511 && wynik <= 634) // 8.31 - 10.34
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 634 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 661 && wynik <= 749) // 11.01 - 12.29
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 749 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 781 && wynik <= 824) // 13.01 - 13.44
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 824 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 886 && wynik <= 949) // 14.46 - 15.49
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 949 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 1041 && wynik <= 1109) // 17.21 - 18.29
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");
				minuty = 1109 - wynik;
				stan.setText("Jeszcze przez " + minuty + " minut(-y)");
			}

			if (wynik >= 1141) // 19.01
			{
				czas.setTextColor(Color.RED);
				czas.setText("ZAMKNIÊTY");

			}
		}
		if (day >= 305 || (day >= 1 && day <= 90)) {
			czas.setTextColor(Color.YELLOW);
			czas.setText("ŒPI");
			stan.setText("snem zimowym do maja ;-)");
		}

		// koniec rozpoznawania daty
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.wodna, menu);
		return true;
	}

	// prze³¹czanie Activity
	@SuppressWarnings("deprecation")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.change:
			mPref.edit().putInt(PREF_LAYOUT, LAYOUT_ZIEMIA).commit();
			Intent intent = new Intent(this, Ziemia.class);
			startActivity(intent);
			finish();
			break;
		case R.id.mopr:
			showDialog(DLG_MOPR);

			break;

		default:
			return super.onOptionsItemSelected(item);
		}

		return true;
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DLG_MOPR:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(R.string.dlg_mopr);
			builder.setIcon(android.R.drawable.ic_dialog_alert);
			builder.setPositiveButton(android.R.string.yes,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Uri number = Uri.parse("tel:984");
							Intent dial = new Intent(Intent.ACTION_CALL, number);
							startActivity(dial);
						}
					});
			builder.setNegativeButton(android.R.string.no, null);
			return builder.create();
		}

		return super.onCreateDialog(id);

	}

}
