package edu.gcit.todo12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "gcit.todo_4.MESSAGE";
    String mOrderMessage;
    View mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton=findViewById(R.id.floatingActionButton);
        Toolbar tool=findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        }


    public void donut(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }

    public void ice(View view) {
        mOrderMessage= getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }

    public void froyo(View view) {
        mOrderMessage=getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, order.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }
}