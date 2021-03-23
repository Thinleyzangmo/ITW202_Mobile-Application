package com.example.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.todo_4.MainActivity.Text_request;

public class MainActivity2 extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity2.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.example.todo_4";
    private EditText mReply;
    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }
    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(LOG_TAG, "onCreate");
        Log.d(LOG_TAG, "-------------");
        Intent obj = getIntent();
        String message = obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
        mReply = findViewById(R.id.editText_second);
    }

    public void returnReply(View view) {
        Log.d(LOG_TAG, "Button click");
        Intent replyIntent = new Intent();
        String reply = mReply.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();

    }
}