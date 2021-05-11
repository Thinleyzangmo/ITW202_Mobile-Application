package edu.gcit.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> link=new LinkedList<>();
    RecyclerView mRview;
    WordListAdapter madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0; i<20;i++){
            link.addLast("Word"+i);
        }

        mRview=findViewById(R.id.recyclerView);
        madapter=new WordListAdapter(this,link);
        mRview.setAdapter(madapter);

        mRview.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                int wordListSize= link.size();
                link.addLast("+Word"+ wordListSize);
                mRview.getAdapter().notifyItemInserted(wordListSize);
                mRview.smoothScrollToPosition(wordListSize);

            }

        });

    }
}