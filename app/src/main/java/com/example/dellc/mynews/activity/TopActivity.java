package com.example.dellc.mynews.activity;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.dellc.mynews.R;
import com.example.dellc.mynews.adapter.TopAdatper;
import com.example.dellc.mynews.fragment.JokeFragment;
import com.example.dellc.mynews.fragment.MainFragment;
import com.example.dellc.mynews.fragment.MyFragment;
import com.example.dellc.mynews.fragment.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellc on 2017/6/23.
 */

public class TopActivity extends FragmentActivity {
    private ViewPager topPager;
    private List<Fragment> topFragmentList =  new ArrayList<>();
    private TopAdatper mAdatper;

    private TextView txtNews;
    private TextView txtJoke;
    private TextView txtWeather;
    private TextView txtMy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        initBottomViews();
        initTopFragmentList();

        topPager = (ViewPager) findViewById(R.id.top_pager);
        mAdatper = new TopAdatper(getSupportFragmentManager(),topFragmentList);
        topPager.setAdapter(mAdatper);
        topPager.setOffscreenPageLimit(4);
    }

    private void initBottomViews() {
        txtNews = (TextView) findViewById(R.id.news_tab);
        txtJoke = (TextView) findViewById(R.id.joke_tab);
        txtWeather = (TextView) findViewById(R.id.weather_tab);
        txtMy = (TextView) findViewById(R.id.my_tab);

        txtNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topPager.setCurrentItem(0);
                txtNews.setTextColor(Color.BLACK);
                txtNews.setTextSize(30);
                txtJoke.setTextColor(Color.WHITE);
                txtJoke.setTextSize(20);
                txtWeather.setTextColor(Color.WHITE);
                txtWeather.setTextSize(20);
                txtMy.setTextColor(Color.WHITE);
                txtMy.setTextSize(20);
            }
        });

        txtJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topPager.setCurrentItem(1);
                txtNews.setTextColor(Color.WHITE);
                txtNews.setTextSize(20);
                txtJoke.setTextColor(Color.BLACK);
                txtJoke.setTextSize(30);
                txtWeather.setTextColor(Color.WHITE);
                txtWeather.setTextSize(20);
                txtMy.setTextColor(Color.WHITE);
                txtMy.setTextSize(20);
            }
        });


        txtWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topPager.setCurrentItem(2);
                txtNews.setTextColor(Color.WHITE);
                txtNews.setTextSize(20);
                txtJoke.setTextColor(Color.WHITE);
                txtJoke.setTextSize(20);
                txtWeather.setTextColor(Color.BLACK);
                txtWeather.setTextSize(30);
                txtMy.setTextColor(Color.WHITE);
                txtMy.setTextSize(20);
            }
        });

        txtMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topPager.setCurrentItem(3);
                txtNews.setTextColor(Color.WHITE);
                txtNews.setTextSize(20);
                txtJoke.setTextColor(Color.WHITE);
                txtJoke.setTextSize(20);
                txtWeather.setTextColor(Color.WHITE);
                txtWeather.setTextSize(20);
                txtMy.setTextColor(Color.BLACK);
                txtMy.setTextSize(30);
            }
        });
    }

    private void initTopFragmentList() {
        MainFragment mf = new MainFragment();
        topFragmentList.add(mf);


        JokeFragment jf = new JokeFragment();
        topFragmentList.add(jf);

        WeatherFragment wf = new WeatherFragment();
        topFragmentList.add(wf);

        MyFragment myf = new MyFragment();
        topFragmentList.add(myf);

    }
}
