package com.example.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;
import org.w3c.dom.Text;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.todo_4";
    private EditText mMessageEditText;
    public static final int Text_request = 1;
    private TextView mReplyHTextView;
    private TextView mReplyTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate");
        Log.d(LOG_TAG, "-------------");
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHTextView = findViewById(R.id.text_header_reply);
        mReplyTV = findViewById(R.id.text_message_reply);
    }

    public void SEND(View view) {
        Log.d(LOG_TAG, "Button click");
        Intent obj = new Intent(this,MainActivity2.class);
        String message = mMessageEditText.getText().toString();
        obj.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(obj, Text_request);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Text_request){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mReplyHTextView.setVisibility(View.VISIBLE);
                mReplyTV.setText(reply);
                mReplyTV.setVisibility(View.VISIBLE);
            }
        }
    }
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
}
