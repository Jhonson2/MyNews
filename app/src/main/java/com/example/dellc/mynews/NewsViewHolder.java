package com.example.dellc.mynews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dellc on 2017/5/19.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder{
    ImageView imgView;
    TextView titleView;


    public NewsViewHolder(View itemView) {
        super(itemView);
        imgView= (ImageView) itemView.findViewById(R.id.item_img);
        titleView= (TextView) itemView.findViewById(R.id.item_title);
    }
}
