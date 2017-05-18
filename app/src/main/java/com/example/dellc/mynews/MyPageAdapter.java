package com.example.dellc.mynews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by dellc on 2017/5/18.
 */

public class MyPageAdapter extends FragmentPagerAdapter {
    private ArrayList<NewsFragment> mFragmentArrayList;
    private ArrayList<String> mTitleList;

    public MyPageAdapter(FragmentManager fm, ArrayList<NewsFragment> fragmentArrayList,
                         ArrayList<String> titleList) {
        super(fm);
        this.mFragmentArrayList=fragmentArrayList;
        this.mTitleList=titleList;
    }

    @Override
    public Fragment getItem(int position) {
        if(mFragmentArrayList.size()<position){
            return  mFragmentArrayList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(mFragmentArrayList == null){
            return  0;
        }
        return mFragmentArrayList.size();
    }

        //标题
    @Override
    public CharSequence getPageTitle(int position) {
        if(mTitleList !=null &&  position <mTitleList.size()){
            return mTitleList.get(position);
        }
        return "noTitle";
    }
}
