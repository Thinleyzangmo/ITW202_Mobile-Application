package edu.gcit.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText mEditWebsite;
    private EditText mEditLocation;
    private EditText mEditShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditWebsite = findViewById(R.id.editTextWeb);
        mEditLocation = findViewById(R.id.editTextLoc);
        mEditShare = findViewById(R.id.editTextshare);
    }

    public void website(View view) {
        String str = mEditWebsite.getText().toString();
        Uri url = Uri.parse(str);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }else{
            Log.d("implicit","Error");
        }

    }

    public void location(View view) {
        String str  = mEditLocation.getText().toString();
        Uri url = Uri.parse("geo:0,0?q=" + str);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else{
            Log.d("implicit","Error");
        }
    }

    public void share(View view) {
        String txt = mEditShare.getText().toString();
        String mimeType = "txt/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Error ")
                .setText(txt)
                .startChooser();

    }
}