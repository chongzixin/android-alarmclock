package com.chongzixin.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "alarmclock" + ".AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, SystemClock.elapsedRealtime() + " in AlarmManager onReceive()");
    }
}
