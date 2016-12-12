package com.dearzou.headline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ZouZhen on 2016/12/11.
 */

public class HeadlineViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;


    public HeadlineViewPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
