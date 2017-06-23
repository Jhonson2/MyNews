package com.example.dellc.mynews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dellc.mynews.R;
import com.example.dellc.mynews.data.JokeData;

import java.util.List;

/**
 * Created by dellc on 2017/6/23.
 */

public class JokeViewAdapter extends RecyclerView .Adapter<JokeViewHolder> {
    private List<JokeData.ResultBean.DataBean> jokeList;

    public  JokeViewAdapter(List<JokeData.ResultBean.DataBean> jokeList){
        this.jokeList = jokeList;
    }

    @Override
    public JokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_item,parent,false);
        JokeViewHolder vh = new JokeViewHolder(itemview);
        return vh;
    }

    @Override
    public void onBindViewHolder(JokeViewHolder holder, int position) {
        JokeData.ResultBean.DataBean joke = jokeList.get(position);
        holder.jokeText.setText(joke.getContent());
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }

    public void changeData(List<JokeData.ResultBean.DataBean> jokeList) {
        this.jokeList = jokeList;
        notifyDataSetChanged();
    }
}
