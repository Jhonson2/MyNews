package com.example.dellc.mynews;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private static final int TOP = 1;
    private static final int YULE = 2;
    private static final int TIYU = 3;
    private static final int KEJI = 4;
    private static final int SHEHUI = 5;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyPageAdapter mPageAdapter;
    private ArrayList<NewsFragment> mFragmentArrayList = new ArrayList<NewsFragment>();
    private ArrayList<String> mTitleList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragmentArrayList();
        initTitleList();

        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mPageAdapter=new MyPageAdapter(getSupportFragmentManager(),mFragmentArrayList,mTitleList);
        mViewPager.setAdapter(mPageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initTitleList() {
        mTitleList.add("头条");
        mTitleList.add("娱乐");
        mTitleList.add("体育");
        mTitleList.add("科技");
    }

    private void initFragmentArrayList() {
        NewsFragment fa = new NewsFragment();
      //  fa.setTxtContent("头条页面");
        Bundle bundle=new Bundle();
        bundle.putInt("NEWSTYPE",1);
        fa.setArguments(bundle);

        NewsFragment fb = new NewsFragment();
       // fb.setTxtContent("娱乐页面");
        Bundle bundle2=new Bundle();
        bundle2.putInt("NEWSTYPE",2);
        fb.setArguments(bundle2);

        NewsFragment fc = new NewsFragment();
      //  fc.setTxtContent("体育页面");
        Bundle bundle3=new Bundle();
        bundle3.putInt("NEWSTYPE",3);
        fc.setArguments(bundle3);

        NewsFragment fd = new NewsFragment();
      //  fd.setTxtContent("科技页面");
        Bundle bundle4=new Bundle();
        bundle4.putInt("NEWSTYPE",4);
        fd.setArguments(bundle4);

        mFragmentArrayList.add(fa);
        mFragmentArrayList.add(fb);
        mFragmentArrayList.add(fc);
        mFragmentArrayList.add(fd);
    }
}
