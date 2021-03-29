package edu.gcit.todo_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int i=-1,j;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.text_show_count);
        if(savedInstanceState !=null){
            i = savedInstanceState.getInt("count");
            mShowCount.setText(toString().valueOf(i));
        }
    }

    public void CountUp(View view) {
        i++;
        mShowCount.setText(String.valueOf(i));
        j=i;

    }

    @Override
    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt("count",j);
    }

}