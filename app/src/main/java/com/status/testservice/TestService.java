package com.status.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class TestService extends Service {
    public TestService() {
        Log.d(MainActivity.TAG, "Constructor");
    }

    @Override
    public void onCreate() {
        Log.d(MainActivity.TAG, "OnCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(MainActivity.TAG, "OnStartCommand");
        new Thread(new Runnable(){
            int c = 0;
            public void run()
            {while(true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(MainActivity.TAG, String.valueOf(c));
                c++;
                if(c == 5){
                    stopSelf();
                    break;
                }

            }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d(MainActivity.TAG, "OnDestroy");
        super.onDestroy();
    }
}
