package pt.ulisboa.tecnico.cmov.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyPhoneReceiver extends BroadcastReceiver {

    private static final String TAG = "TAG_MyPhoneReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == TelephonyManager.ACTION_PHONE_STATE_CHANGED){
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if (state != null) {
                Log.i(TAG, "Call state changed: " + state);
            }

            if (number != null) {
                Log.i(TAG, "Incoming call from: " + number);
            }
        }

    }
}