package com.czajo.mostobrotowywgizycku;

import java.util.Calendar;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Wodna extends Activity {
	
	private TextView czas, stan, miesiac;

	public static final String PREFS_NAME = "MyPrefsFile1";
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
		setContentView(R.layout.activity_wodna);
		
		czas = (TextView) findViewById(R.id.czas);
        stan = (TextView) findViewById(R.id.stan);
        
        /*SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String activityname = settings.getString("activityName", "Wodna");
        if (activityname.equals("Wodna"))
        {
        	Intent intent = new Intent(this, Wodna.class);
            this.startActivity(intent);
            finish();
        }
        if (activityname.equals("MainActivity"))
        {
        	Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
            finish();
        }*/
        
        //rozpoznawanie daty 
        
        //miesiac = (TextView) findViewById(R.id.miesiac);        
        //miesiac.setText(String.valueOf(day));
        updateView();
	}
	
	public void updateView(){
		Calendar c = Calendar.getInstance(); 
		int min = c.get(Calendar.MINUTE);
		int hours = c.get(Calendar.HOUR_OF_DAY);
		int day = c.get(Calendar.DAY_OF_YEAR) ;
		int wynik = (hours * 60 ) + min;
		int minuty;
        if ((day >= 118 && day <= 126) || (day >= 152 && day <= 259)) //28 kwietnia do 6 maja i od 1 czerwca do 16 wrzeœnia
        {
        	//MOST OTWARTY DLA RUCHU WODNEGO 
            if (hours == 0 || hours == 1 || hours == 2 || hours == 3 || hours == 4 || hours == 5 || hours == 6 || hours == 7)
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            }
            
            if (wynik >= 490 && wynik <= 510) //8.10 - 8.30
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
                         
          //MOST ZAMKNIÊTY DLA RUCHU WODNEGO
            if (wynik >= 511 && wynik <= 634) //8.31 - 10.34
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 634 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 661 && wynik <= 749) //11.01 - 12.29
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 749 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 781 && wynik <= 824) //13.01 - 13.44
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 824 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >=886 && wynik <= 949) //14.46 - 15.49
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 949 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 1041 && wynik <= 1109) //17.21 - 18.29
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 1109 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 1141) //19.01
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");

            } 
        }
        
        if ((day >= 91 && day <= 117) || (day >= 127 && day <= 151) || (day >= 260 && day <= 304)) // 1 do 27 kwietnia, od 7 do 31 maja oraz od 17 wrzeœnia do 31 paŸdziernika
        {
        	//MOST OTWARTY DLA RUCHU WODNEGO
            if (hours == 0 || hours == 1 || hours == 2 || hours == 3 || hours == 4 || hours == 5 || hours == 6 || hours == 7 || hours == 8 || hours == 9)
            {
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
            
                         
          //MOST ZAMKNIÊTY DLA RUCHU WODNEGO
            if (wynik >= 511 && wynik <= 634) //8.31 - 10.34
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 634 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 661 && wynik <= 749) //11.01 - 12.29
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 749 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 781 && wynik <= 824) //13.01 - 13.44
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 824 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >=886 && wynik <= 949) //14.46 - 15.49
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 949 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 1041 && wynik <= 1109) //17.21 - 18.29
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 1109 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 1141) //19.01
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");

            }
        }
        if (day >= 305 || (day >= 1 && day <= 90))
        {
        	czas.setTextColor(Color.YELLOW);
        	czas.setText("ŒPI");
        	stan.setText("snem zimowym do maja ;-)");
        }
        
        //koniec rozpoznawania daty
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wodna, menu);
		return true;
	}
	
    @Override
	protected void onPause() {
		super.onPause();
		
		unregisterReceiver(mBroadcastReceiver);
	}
    
	//prze³¹czanie Activity 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
        case R.id.item1w:
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("activityName", "MainActivity");
            editor.commit();
            finish();
            break;
        case R.id.item2w:
        	AlertDialog.Builder builder = new AlertDialog.Builder(this);
        	builder
        	.setTitle("ZadŸwoñ do MOPR")
        	.setMessage("Czy na pewno chcesz to zrobiæ?")
        	.setIcon(android.R.drawable.ic_dialog_alert)
        	.setPositiveButton("TAK", new DialogInterface.OnClickListener() {
        	    public void onClick(DialogInterface dialog, int which) {			      	       	    	
        	    	Uri number = Uri.parse("tel:984");
              	  Intent dial = new Intent(Intent.ACTION_CALL, number);
              	  startActivity(dial);
        	    }
        	})
        	.setNegativeButton("NIE", null)						//Do nothing on no
        	.show();
        	
            break;
        case R.id.item3w:
            Intent about = new Intent(this, About.class);
            this.startActivity(about);
            break;

        default:
            return super.onOptionsItemSelected(item);
        }

        return true;
    }


}
