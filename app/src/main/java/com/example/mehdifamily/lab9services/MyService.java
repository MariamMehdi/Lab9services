package com.example.mehdifamily.lab9services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mehdi Family on 3/9/2018.
 */

public class MyService extends Service {

    private Timer timer;
    private TimerTask timerTask;
    private Handler myHandler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"Service created",Toast.LENGTH_LONG).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_LONG).show();
        startTimer();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopTimer();
        Toast.makeText(getApplicationContext(),"Service destroyed",Toast.LENGTH_LONG).show();
    }

    public void startTimer(){
        timer=new Timer();
        myHandler=new Handler();

        timerTask=new TimerTask() {
            @Override
            public void run() {
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"Service running",Toast.LENGTH_LONG).show();
                    }
                });
            }
        };
        timer.schedule(timerTask,0,5000);
    }
    public void stopTimer(){
        timer.cancel();
    }
}