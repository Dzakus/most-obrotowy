package com.czajo.mostobrotowywgizycku;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class Notyfikacja extends Activity implements OnClickListener {
 
    Button notificationFull;
    Button notificationToast;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.notyfikacja);
 
 
        notificationFull.setOnClickListener(this);
        notificationToast.setOnClickListener(this);
 
    }
 
    public void aktualizacja(View v) {
 

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);             
            mBuilder.setContentTitle("Zmiana stanu mostu");
            mBuilder.setContentText("Opis powiadomienia");
            mBuilder.setSmallIcon(R.drawable.ic_launcher);
            Intent mIntent = new Intent(this, MainActivity.class);
            PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);            
            mBuilder.setContentIntent(mPendingIntent);
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, mBuilder.build());
 
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
 
}