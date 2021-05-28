package edu.gcit.todo_22;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {
    private String mQuerString;


    public BookLoader(Context context, String queryString) {
        super(context);
        mQuerString=queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return networkUtils.getBookInfo(mQuerString);
    }
}
