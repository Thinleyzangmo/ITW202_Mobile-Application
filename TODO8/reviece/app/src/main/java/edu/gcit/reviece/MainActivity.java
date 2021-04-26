package edu.gcit.reviece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tview = findViewById(R.id.textview1);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri!=null){
            String msg = uri.toString();
            tview.setText(msg);
        }

    }
}