package com.czajo.mostobrotowywgizycku;

import java.util.Calendar;

import android.content.Intent;
import android.graphics.Color;
import android.view.MenuItem;

public class Ziemia extends myActivity {
	
	
	public static final String PREFS_NAME = "MyPrefsFile1";

	public void updateView(){
    	Calendar c = Calendar.getInstance(); 
    	int min = c.get(Calendar.MINUTE);
    	int hours = c.get(Calendar.HOUR_OF_DAY);
    	int day = c.get(Calendar.DAY_OF_YEAR) ;
    	int wynik = (hours * 60 ) + min;
    	int minuty;
        if ((day >= 118 && day <= 126) || (day >= 152 && day <= 259))
        {
        	//MOST OTWARTY DLA RUCHU KO£OWEGO
            if (hours == 0 || hours == 1 || hours == 2 || hours == 3 || hours == 4 || hours == 5 || hours == 6 || hours == 7)
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            }
            
            if (wynik >= 515 && wynik <= 630) //8.35 - 10.30
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 630 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            }
            
            if (wynik >= 665 && wynik <= 745) // 11.05 - 12.25
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 745 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            }
            
            if (wynik >= 785 && wynik <= 820) // 13.05 - 13.40
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 820 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            }
            
            if (wynik >= 890 && wynik <= 945) // 14.50 - 15.45
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 945 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            }
            
            if (wynik >= 1045 && wynik <= 1105) // 17.25 - 18.25
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 1105 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            }
            
            if (wynik >= 1145) // 19.05 - 8.05
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 485 - wynik;
            }
                         
          //MOST ZAMKNIÊTY DLA RUCHU KO£OWEGO
            if (wynik >= 631 && wynik <= 664) //10.31 - 11.04
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 664 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 746 && wynik <= 784) //12.26 - 13.04
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 784 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 821 && wynik <= 889) //13.41 - 14.49
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty =889 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >=946 && wynik <= 1044) //15.46 - 17.24
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 1044 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 1106 && wynik <= 1144) //18.26 - 19.04
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 1144 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 486 && wynik <= 514) //08.06 - 08.34
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 514 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
        }
        
        if ((day >= 91 && day <= 117) || (day >= 127 && day <= 151) || (day >= 260 && day <= 304))
        {
        	//MOST OTWARTY DLA RUCHU KO£OWEGO
            if (hours == 0 || hours == 1 || hours == 2 || hours == 3 || hours == 4 || hours == 5 || hours == 6 || hours == 7 || hours == 8 || hours == 9)
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            }
            
            
            if (wynik >= 665 && wynik <= 745) // 11.05 - 12.25
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 745 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            }
            
            if (wynik >= 785 && wynik <= 820) // 13.05 - 13.40
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 820 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            }
            
            if (wynik >= 890 && wynik <= 945) // 14.50 - 15.45
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            	minuty = 945 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            }
            
            if (wynik >= 1045) // 17.25 - 18.25
            {
            	czas.setTextColor(Color.GREEN);
            	czas.setText("OTWARTY");
            }
                         
          //MOST ZAMKNIÊTY DLA RUCHU KO£OWEGO
            if (wynik >= 631 && wynik <= 664) //10.31 - 11.04
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 664 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 746 && wynik <= 784) //12.26 - 13.04
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 784 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >= 821 && wynik <= 889) //13.41 - 14.49
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty =889 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
            } 
            
            if (wynik >=946 && wynik <= 1044) //15.46 - 17.24
            {
            	czas.setTextColor(Color.RED);
            	czas.setText("ZAMKNIÊTY");
            	minuty = 1044 - wynik;
            	stan.setText("Jeszcze przez " + minuty + " minut(-y)");
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

	//prze³¹czanie Activity 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
        case R.id.change:
            mPref.edit().putInt(PREF_LAYOUT,LAYOUT_WODA).commit();
        	Intent intent = new Intent(this, Wodna.class);
            startActivity(intent);
            finish();
            break;

        default:
            return super.onOptionsItemSelected(item);
        }

        return true;
    }  
    
}
