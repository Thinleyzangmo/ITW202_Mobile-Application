package edu.gcit.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<sports> mSportsData;
    private sportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gridcolumn=getResources().getInteger(R.integer.grid_column);

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridcolumn));

        mSportsData = new ArrayList<>();
        mAdapter = new sportsAdapter(this, mSportsData);
        recyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        TypedArray sportsImageResource = getResources().obtainTypedArray(R.array.sports_image);
        String[] sportsList = getResources().getStringArray(R.array.sports_title);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        mSportsData.clear();

        for (int i = 0; i < sportsList.length; i++){
            mSportsData.add(new sports(sportsList[i], sportsInfo[i], sportsImageResource.getResourceId(i, 0)));
        }

        mAdapter.notifyDataSetChanged();
        sportsImageResource.recycle();
    }
}