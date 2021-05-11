package edu.gcit.todo_16;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> list;
    private LayoutInflater minflater;

    public WordListAdapter(Context contex,LinkedList<String> list){
        minflater=LayoutInflater.from(contex);
        this.list=list;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView= minflater.inflate(R.layout.wordlist_item,parent, false);
        return  new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mcurrent=list.get(position);
        holder.wordItemView.setText(mcurrent);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView wordItemView;
        final WordListAdapter mAdapter;


        public WordViewHolder(@NonNull View itemView, WordListAdapter mAdapter) {
            super(itemView);
            wordItemView=itemView.findViewById(R.id.textView);
            this.mAdapter= mAdapter;
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            int mPosition=getAdapterPosition();
            String element=list.get(mPosition);
            list.set(mPosition, "Clicked"+ element);
            mAdapter.notifyDataSetChanged();

        }
    }
}
