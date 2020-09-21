package com.chongzixin.alarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "alarmclock" + ".MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setAlarm(View view) {
        Context context = getApplicationContext();
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        long nextTrigger = System.currentTimeMillis()+10000;
        Log.i(TAG, System.currentTimeMillis() + ": scheduling next alarm at " + nextTrigger);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        AlarmManager.AlarmClockInfo ac = new AlarmManager.AlarmClockInfo(nextTrigger, null);
        alarmManager.setAlarmClock(ac, pendingIntent);
    }
}