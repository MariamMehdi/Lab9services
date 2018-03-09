package com.example.mehdifamily.lab9services;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent i = new Intent(MainActivity.this, MyService.class);

        Button start = (Button) findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(i);
            }
        });

        Button stop = (Button) findViewById(R.id.btnStop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(i);
            }
        });

        Button Notify = (Button) findViewById(R.id.btnNotify);
        Notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
    }

    public void sendNotification(){
        NotificationCompat.Builder myBuilder = new NotificationCompat.Builder(this);
        myBuilder.setContentTitle("My first notification");
        myBuilder.setContentText("Hello everyone!");
        myBuilder.setSmallIcon(android.R.drawable.btn_plus);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1,myBuilder.build());

    }
}