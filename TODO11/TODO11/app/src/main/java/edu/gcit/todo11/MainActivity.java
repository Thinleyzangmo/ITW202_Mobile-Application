package edu.gcit.todo11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mText;

    private String[] mColor = {"g1", "g2", "g3", "g4",
            "g5", "g6", "g7", "g8", "g9", "g10",
            "g11", "g12"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText=findViewById(R.id.textview);

    }

    public void change_colour(View view) {
        Random color = new Random();
        String colorName = mColor[color.nextInt(12)];

        int colorresource = getResources().getIdentifier(colorName, "color",
                getApplicationContext().getPackageName());


        int colorRes = ContextCompat.getColor(this, colorresource);


        mText.setTextColor(colorRes);

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putInt("color", mText.getCurrentTextColor());
    }
}