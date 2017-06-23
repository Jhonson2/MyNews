package com.example.dellc.mynews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dellc.mynews.R;

/**
 * Created by dellc on 2017/6/23.
 */
public class JokeViewHolder extends RecyclerView.ViewHolder{
    TextView jokeText;

    public JokeViewHolder(View itemView) {
        super(itemView);
        jokeText= (TextView) itemView.findViewById(R.id.joke_text);
    }
}
