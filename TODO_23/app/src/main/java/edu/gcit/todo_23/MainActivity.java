package edu.gcit.todo_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CustomReciever reciever= new CustomReciever();
    private static final String ACTION_CUSTOM_BROADCAST=BuildConfig.APPLICATION_ID+ ".ACTION_CUSTOM_BROADCAST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);

        this.registerReceiver(reciever,filter);

        LocalBroadcastManager.getInstance(this).unregisterReceiver(reciever);

    }
@Override
    protected void onDestroy() {
        this.unregisterReceiver(reciever);
        super.onDestroy();
}

    public void SendCustomBroadcast(View view) {
        Intent customBroadcastIntent=new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);

    }
}