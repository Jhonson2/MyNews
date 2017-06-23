package com.example.dellc.mynews.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dellc on 2017/6/23.
 */

public class TopAdatper extends FragmentPagerAdapter {
    private List<Fragment> topFragmentList;

    public TopAdatper(FragmentManager fm,List<Fragment> topFragmentList) {
        super(fm);
        this.topFragmentList=topFragmentList;
    }

    @Override
    public Fragment getItem(int position) {

        return topFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return topFragmentList.size();
    }
}
