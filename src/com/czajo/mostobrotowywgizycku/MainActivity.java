package com.czajo.mostobrotowywgizycku;

import java.util.Calendar;

import com.czajo.mostobrotowywgizycku.R.string;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {
        
        private TextView czas, stan, miesiac;

        public static final String PREFS_NAME = "MyPrefsFile1";
        public CheckBox dontShowAgain;

        BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver(){

                @Override
                public void onReceive(Context context, Intent intent) {
                        String action = intent.getAction();
                        if(action.equals(Intent.ACTION_TIME_TICK)){
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
            int minuty = 0;
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
                    if (minuty <= 10)
                    	createNotification();
            }
            
            if (wynik >= 665 && wynik <= 745) // 11.05 - 12.25
            {
                    czas.setTextColor(Color.GREEN);
                    czas.setText("OTWARTY");
                    minuty = 745 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            }
            
            if (wynik >= 785 && wynik <= 820) // 13.05 - 13.40
            {
                    czas.setTextColor(Color.GREEN);
                    czas.setText("OTWARTY");
                    minuty = 820 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            }
            
            if (wynik >= 890 && wynik <= 945) // 14.50 - 15.45
            {
                    czas.setTextColor(Color.GREEN);
                    czas.setText("OTWARTY");
                    minuty = 945 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            }
            
            if (wynik >= 1045 && wynik <= 1105) // 17.25 - 18.25
            {
                    czas.setTextColor(Color.GREEN);
                    czas.setText("OTWARTY");
                    minuty = 1105 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            }
            
            if (wynik >= 1145) // 19.05 - 8.05
            {
                    czas.setTextColor(Color.GREEN);
                    czas.setText("OTWARTY");
                    minuty = 485 - wynik;
            }
                         
          //MOST ZAMKNIĘTY DLA RUCHU KOŁOWEGO
            if (wynik >= 631 && wynik <= 664) //10.31 - 11.04
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty = 664 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            } 
            
            if (wynik >= 746 && wynik <= 784) //12.26 - 13.04
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty = 784 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            } 
            
            if (wynik >= 821 && wynik <= 889) //13.41 - 14.49
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty =889 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            } 
            
            if (wynik >=946 && wynik <= 1044) //15.46 - 17.24
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty = 1044 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            } 
            
            if (wynik >= 1106 && wynik <= 1144) //18.26 - 19.04
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty = 1144 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            } 
            
            if (wynik >= 486 && wynik <= 514) //08.06 - 08.34
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty = 514 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
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
                    if (minuty <= 10)
                    	createNotification();
            }
            
            if (wynik >= 785 && wynik <= 820) // 13.05 - 13.40
            {
                    czas.setTextColor(Color.GREEN);
                    czas.setText("OTWARTY");
                    minuty = 820 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            }
            
            if (wynik >= 890 && wynik <= 945) // 14.50 - 15.45
            {
                    czas.setTextColor(Color.GREEN);
                    czas.setText("OTWARTY");
                    minuty = 945 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            }
            
            if (wynik >= 1045) // 17.25 - 18.25
            {
                    czas.setTextColor(Color.GREEN);
                    czas.setText("OTWARTY");
            }
                         
          //MOST ZAMKNIĘTY DLA RUCHU KO£OWEGO
            if (wynik >= 631 && wynik <= 664) //10.31 - 11.04
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty = 664 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            } 
            
            if (wynik >= 746 && wynik <= 784) //12.26 - 13.04
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty = 784 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            } 
            
            if (wynik >= 821 && wynik <= 889) //13.41 - 14.49
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty =889 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            } 
            
            if (wynik >=946 && wynik <= 1044) //15.46 - 17.24
            {
                    czas.setTextColor(Color.RED);
                    czas.setText("ZAMKNIĘTY");
                    minuty = 1044 - wynik;
                    stan.setText("Jeszcze przez " + minuty + " minut(-y)");
                    if (minuty <= 10)
                    	createNotification();
            }            
        }
        if (day >= 305 || (day >= 1 && day <= 90))
        {
                czas.setTextColor(Color.YELLOW);
                czas.setText("ŚPI");
                stan.setText("snem zimowym do maja ;-)");
        }
        
        //koniec rozpoznawania daty

        
    }
        //Tworzenie powiadomienia
        private void createNotification() {

            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

            Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
            String czas2 = ("OTWARTY");
            if (czas2 != czas.getText()) 
            {            
            Notification noti = new NotificationCompat.Builder(this)
            .setContentTitle("Za 10 minut")
            .setContentText("Most będzie " + czas.getText())
            .setTicker("Zmiana stanu mostu za 10 minut!")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setLargeIcon(icon)
            .setAutoCancel(true)
            .setContentIntent(pIntent)
            .build();    
            
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(0, noti);
            }
            else 
            {
            	Notification noti = new NotificationCompat.Builder(this)
            	.setContentTitle("Za 10 minut")
            	.setContentText("Most będzie " + czas2)
            	.setTicker("Zmiana stanu mostu za 10 minut!")
            	.setSmallIcon(android.R.drawable.ic_dialog_info)
            	.setLargeIcon(icon)
            	.setAutoCancel(true)
            	.setContentIntent(pIntent)
            	.build();  




            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(0, noti);
            }
        }
        //koniec powiadomienia
        
    //pokazywanie alertboxa przy pierwszym uruchomieniu aplikacji
        @Override
        protected void onResume() {

                    AlertDialog.Builder adb = new AlertDialog.Builder(this);
                    LayoutInflater adbInflater = LayoutInflater.from(this);
                    View eulaLayout = adbInflater.inflate(R.layout.checkbox, null);
                    dontShowAgain = (CheckBox) eulaLayout.findViewById(R.id.skip);
                    adb.setView(eulaLayout);
                    adb.setTitle("Attention");
                    adb.setMessage(Html.fromHtml("Ta aplikacja zawiera również tryb wodny. Aktywować go można poprzez klawisz 'menu'. W trybie wodnym można również szybko zadzwonić do giżyckiej bazy MOPR! Aplikacja działa statycznie na podstawie godzin, więc nie odpowiadam za dróżnika. Maciej Czajkowski"));
                    adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String checkBoxResult = "NOT checked";
                            if (dontShowAgain.isChecked())
                                checkBoxResult = "checked";
                            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                            SharedPreferences.Editor editor = settings.edit();
                            editor.putString("skipMessage", checkBoxResult);
                            editor.commit();                 
                            return;
                        }

                    });



            IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
            registerReceiver(mBroadcastReceiver, filter);
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            String skipMessage = settings.getString("skipMessage", "NOT checked");
            if (!skipMessage.equals("checked"))
                adb.show();

            super.onResume();
        }
  //koniec kodu alertboxa
    @Override
        protected void onPause() {
                super.onPause();
                unregisterReceiver(mBroadcastReceiver);
        }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //przełączanie Activity 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
        case R.id.item1:
            Intent intent = new Intent(this, Wodna.class);
            this.startActivity(intent);
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("activityName", "Wodna");
            editor.commit();
            finish();
            break;
        case R.id.item2:
            Intent about = new Intent(this, About.class);
            this.startActivity(about);
            break;

        default:
            return super.onOptionsItemSelected(item);
        }

        return true;
    }  
    
}