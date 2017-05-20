package com.example.dellc.mynews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dellc on 2017/5/19.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{
    private List<NewsData.ResultBean.NewsBean> mNewsList;

    public NewsAdapter( List<NewsData.ResultBean.NewsBean> newsList){
        this.mNewsList=newsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        NewsViewHolder holder=new NewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsData.ResultBean.NewsBean news=mNewsList.get(position);

       // news.getImgurl() 通过聚合网络获取 //holder.imgView

        Glide.with(holder.imgView.getContext())
                .load(news.getThumbnail_pic_s())
                .into(holder.imgView);
        holder.titleView.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void changData(List<NewsData.ResultBean.NewsBean> newsList) {
        this.mNewsList = newsList;
        notifyDataSetChanged();
    }
}
